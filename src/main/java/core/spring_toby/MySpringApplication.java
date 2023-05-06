package core.spring_toby;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass,String... args) {
        //spring 컨테이너 생성
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
            @Override
            protected void onRefresh() {// onRefresh가 불리는 시점에 초기화 작업 수행
                super.onRefresh();

                //인스턴스 생성은 스프링 컨테이너에 등록된 빈을 가져와서 사용
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                dispatcherServlet.setApplicationContext(this);

                //익명 클래스 코드 작업
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(this) // dispatcherServlet은 웹 어플리케이션 context를 사용해야한다.
                    ).addMapping("/*");// '/hello'로 들어온 리소스는 해당 object가 처리하겠다. '/*' 경우 모든 리소스를 처리하겠다 (front Controller)
                });
                webServer.start();

            }
        };
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}

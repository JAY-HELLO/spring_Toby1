package core.spring_toby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@Configuration
public class SpringTobyApplication {
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService(){
        return new SimpleHelloService();
    }
    public static void main(String[] args) {

        //spring 컨테이너 생성
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
            @Override
            protected void onRefresh() {// onRefresh가 불리는 시점에 초기화 작업 수행
                super.onRefresh();

                //servlet 컨테이너 생성
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                //익명 클래스 코드 작업
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(this) // dispatcherServlet은 웹 어플리케이션 context를 사용해야한다.
                    ).addMapping("/*");// '/hello'로 들어온 리소스는 해당 object가 처리하겠다. '/*' 경우 모든 리소스를 처리하겠다 (front Controller)
                });
                webServer.start();
                
            }
        };
        applicationContext.register(SpringTobyApplication.class);
        applicationContext.refresh();

        
    }

}

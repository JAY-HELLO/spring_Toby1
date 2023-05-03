package core.spring_toby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

public class SpringTobyApplication {

    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        //익명 클래스 코드 작업
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                    //인증, 보안, 다국어, 공통기능등을 frontController 에서 처리해야함
                    if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
                        String name = req.getParameter("name");

                        //hello Controller을 활용하는 front Controller
                        String ret = helloController.hello(name); // 바인딩 작업.

                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    }
                    else if(req.getRequestURI().equals("/user")){
                        //
                    }else{
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }

                    //웹 응답의 3개 요소
                    //1. 상태라인에서 상태코드
                    //2. 헤더 특히 content type 헤더
                    //3. body 부분
                    // 를 구현해야한다

                }
            }).addMapping("/*");// '/hello'로 들어온 리소스는 해당 object가 처리하겠다. '/*' 경우 모든 리소스를 처리하겠다 (front Controller)

        });
        webServer.start();
    }

}

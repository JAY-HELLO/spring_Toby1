package core.spring_toby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpringTobyApplication {

    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        //익명 클래스 코드 작업
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    //웹 응답의 3개 요소
                    //1. 상태라인에서 상태코드
                    //2. 헤더 특히 content type 헤더
                    //3. body 부분
                    // 를 구현해야한다
                    resp.setStatus(200);
                    resp.setHeader("Content-Type", "text/plain");
                    resp.getWriter().println("hello servlet");
                }
            }).addMapping("/hello");// '/hello'로 들어온 리소스는 해당 object가 처리하겠다.

        });
        webServer.start();
    }

}

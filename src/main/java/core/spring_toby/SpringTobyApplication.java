package core.spring_toby;

import core.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class SpringTobyApplication {

    public static void main(String[] args) {
        // 처음 스프링 부트 어플리케이션을 생성할떄의 모양과 동일함을 알 수 있다.
        //MySpringApplication.run(SpringTobyApplication.class, args);
        SpringApplication.run(SpringTobyApplication.class,args);
    }

}

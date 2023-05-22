package core.spring_toby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringTobyApplication {

    private final JdbcTemplate jdbcTemplate;

    public SpringTobyApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }
    public static void main(String[] args) {
        // 처음 스프링 부트 어플리케이션을 생성할떄의 모양과 동일함을 알 수 있다.
        //MySpringApplication.run(SpringTobyApplication.class, args);
        SpringApplication.run(SpringTobyApplication.class,args);
    }

}

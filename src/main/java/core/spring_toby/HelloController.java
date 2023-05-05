package core.spring_toby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}

package core.spring_toby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class HelloController {
    public String hello(String name){
        return "Hello " + name;
    }
}

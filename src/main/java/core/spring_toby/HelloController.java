package core.spring_toby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    /***
     * dispatcher servlet은 application Context에서 정보를 받아서 웹 요청을 처리할 수 있는 매핑정보를 같은 클래스를 찾고
     * 매핑에 사용할 매핑 테이블을 만들고, 웹 요청이 들어오면 참고한다.
     * 클래스 레벨을 먼저 찾고 그다음 메소드 레벨을 찾는다.
     * @param name
     * @return
     */
    @GetMapping
    @ResponseBody
    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}

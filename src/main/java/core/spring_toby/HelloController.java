package core.spring_toby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@MyComponent// spring컨테이너에 들어가는 컴포넌트 선언 //component 어노테이션을 메타 어노테이션으로 가진 어노테이션
//@Component
@RestController
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

    //@ResponseBody RestController는 responseBody를 메타 어노테이션으로 가짐
    @GetMapping("/hello")
    public String hello(String name) {

        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name){
        return  "name : " + helloService.countOf(name);
    }
}

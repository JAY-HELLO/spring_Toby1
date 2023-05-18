package core.spring_toby;

import core.spring_toby.study.HellobootTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@HellobootTest
@Transactional
public class HelloServiceCountTest {
    @Autowired HelloService helloService;@Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount(){

        IntStream.rangeClosed(1, 10).forEach( count ->{
            helloService.sayHello("toby");
            Assertions.assertThat(helloRepository.countOf("toby")).isEqualTo(count);
            }
        );
    }
}

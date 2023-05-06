package core.spring_toby;

import org.springframework.stereotype.Service;

@Service
public interface HelloService {

    String sayHello(String name);
}

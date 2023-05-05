package core.spring_toby;

public class SimpleHelloService implements HelloService{

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}

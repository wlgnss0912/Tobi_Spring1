package tobyspring.helloboot;

import java.util.Objects;


public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));//null은 예외를 던지고 아니면 값 return
    }
}

package core.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration(proxyBeanMethods = false)// MyAutoConfiguration이 붙은 어노테이션은 proxy Bean Method가 false 로 적용된다
public @interface MyAutoConfiguration {
}

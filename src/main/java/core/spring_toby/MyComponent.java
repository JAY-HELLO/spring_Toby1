package core.spring_toby;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 생명주기
@Target(ElementType.TYPE)//어노테이션의 타겟
@Component
public @interface MyComponent {
}

package core.config;

import core.config.EnableMyAutoConfiguration;
import core.config.autoconfig.DispatcherServletConfig;
import core.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan//@Component가 붙은 모든 클래스를 빈에 등록
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}

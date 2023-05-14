package core.config.autoconfig;

import core.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@MyAutoConfiguration
@Conditional(TomcatWebServerConfig.ToncatCondition.class)
public class TomcatWebServerConfig {
    @Bean("TomcatWebServerFactory")// 빈 이름 직접 지정
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    static class ToncatCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}

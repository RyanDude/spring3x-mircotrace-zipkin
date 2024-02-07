package org.cloud.sample.Config;

import org.cloud.sample.Utils.JwtTool;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({JwtTool.class})
public class BeanConfig {
    @Bean
    public JwtTool jwtTool(){
        return new JwtTool();
    }
}

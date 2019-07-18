package com.github.sioncheng.autoconf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnBean(MyServerMarkerConfiguration.Marker.class)
@Import(MyServerInitializerConfiguration.class)
public class MyServerAutoConfiguration implements WebMvcConfigurer {

    @Bean
    public MyServerController myServerController() {
        return new MyServerController();
    }
}

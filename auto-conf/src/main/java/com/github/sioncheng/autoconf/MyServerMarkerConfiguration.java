package com.github.sioncheng.autoconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServerMarkerConfiguration {

    public static class Marker {}

    @Bean
    public MyServerMarkerConfiguration.Marker marker() {
        System.out.println("============== MyServerMarkerConfiguration ===============");
        return new MyServerMarkerConfiguration.Marker();
    }
}

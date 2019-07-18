package com.github.sioncheng.autoconf.apply;

import com.github.sioncheng.autoconf.EnableMyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMyServer
public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class);
    }
}

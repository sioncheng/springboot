package com.github.sioncheng.autoconf.apply;

import com.github.sioncheng.autoconf.EnableMyServer;
import com.github.sioncheng.autoconf.MySelectedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMyServer
public class StartApp implements ApplicationRunner {

    @Autowired(required = false)
    private MySelectedClass mySelectedClass;

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(mySelectedClass);
    }
}

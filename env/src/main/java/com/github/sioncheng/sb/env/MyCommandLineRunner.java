package com.github.sioncheng.sb.env;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        Object o = this.applicationContext.getBean(MyProperties.class);
        System.out.println("aaa " + (o != null));

        MyProperties myProperties = (MyProperties)o;
        System.out.println(myProperties);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

package com.github.sioncheng.spring.aliasfor;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyService
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyServiceService {

    @AliasFor(annotation =  MyService.class)
    String value() default "my-service-service";
}

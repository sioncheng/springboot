package com.github.sioncheng.spring.aliasfor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.spel.support.ReflectionHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;

@Component
public class SpringAwareBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        printBeans();
    }

    private void printBeans() {
        Object o = this.applicationContext.getBean(MyServiceBean.class);
        System.out.println( o == null);
        MyServiceBean myServiceBean = (MyServiceBean)o;
        System.out.println(myServiceBean == null);

        MyService myService = AnnotationUtils.getAnnotation(MyServiceBean.class, MyService.class);
        System.out.println(myService == null);
        System.out.println(myService.value());

        MyServiceService myServiceService = AnnotationUtils.getAnnotation(MyServiceBean.class, MyServiceService.class);
        System.out.println(myServiceService == null);
        System.out.println(myServiceService.value());

        MyService myService1 = AnnotatedElementUtils.findMergedAnnotation(MyServiceBean.class, MyService.class);
        System.out.println(myService1 == null);
        System.out.println(myService1.value());
    }
}

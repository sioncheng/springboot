package springbt;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Dog implements HiAminal , ApplicationContextAware, ApplicationListener {

    public String hi() {
        return "wang";
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set application context");
    }

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("on application evnet " + event.toString());
    }
}

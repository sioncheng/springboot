package springbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        printEvent("constructor");
    }

    public void starting() {
        printEvent("starting");
    }

    public void started() {
        printEvent("started");
    }

    public void environmentPrepared(ConfigurableEnvironment environment) {
        printEvent("environment prepared");
    }

    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        printEvent("finished");
    }

    public void contextLoaded(ConfigurableApplicationContext context) {
        printEvent("context loaded");
    }

    public void contextPrepared(ConfigurableApplicationContext context) {
        printEvent("context prepared");
    }

    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        printEvent("failed");
    }

    public void running(ConfigurableApplicationContext context) {
        printEvent("running");
    }

    public void started(ConfigurableApplicationContext context) {
        printEvent("started");
    }

    private void printEvent(String event) {
        System.out.println("====== " + event);
    }
}

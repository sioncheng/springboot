package com.github.sioncheng.autoconf;

import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServerInitializerConfiguration implements SmartLifecycle {

    private boolean running;

    @Override
    public void start() {
        System.out.println("======== MyServerInitializerConfiguration start ========");
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public int getPhase() {
        return 0;
    }


}

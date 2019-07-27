package com.github.sioncheng.sb.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;


public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        Resource resource = new ClassPathResource("/myenv.properties");
        if (!resource.exists()) {
            System.out.println("no property file /myenv.properties");
            return;
        }

        System.out.println("find property file /myenv.properties");

        try {
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            PropertiesPropertySource propertiesPropertySource =
                    new PropertiesPropertySource("my", properties);

            environment.getPropertySources().addLast(propertiesPropertySource);
        } catch (IOException ie) {
        } finally {

        }
    }
}

package sbt.bookpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import sbt.db.count.starter.EnableDbCounterConfig;

@SpringBootApplication
@EnableScheduling
@EnableDbCounterConfig
public class BookPubApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookPubApplication.class);
    }
}

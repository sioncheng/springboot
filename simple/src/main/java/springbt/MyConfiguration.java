package springbt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MyConfiguration {

    //@Bean
    public HiAminal hiAminal() {
        if (System.currentTimeMillis() % 2 == 0) {
            System.out.println("return dog");
            return new Dog();
        } else {
            System.out.println("return cat");
            return new Cat();
        }
    }

    @Bean
    public HiAminal hiDog() {
        return new Dog();
    }
}

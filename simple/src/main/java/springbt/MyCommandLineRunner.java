package springbt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner  implements CommandLineRunner {

    public void run(String... args) {
        System.out.println("my command line runner");
        System.out.println(args);
    }
}

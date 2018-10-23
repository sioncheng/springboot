package springbt;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.io.ClassPathResource;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class MainApp {



    public static void main0(String[] args) {
        System.out.println("before spring run");
        ConfigurableApplicationContext ctx = SpringApplication.run(MainApp.class, args);
        System.out.println("after spring run");
        HiAminal hiAminal = ctx.getBean(HiAminal.class);
        System.out.println(hiAminal.hi());

    }

    public static void main1(String[] args) {
        Class<?> clzz = HiAminal.class;
        Annotation[] annotations = clzz.getDeclaredAnnotations();
        for (Annotation an :
                annotations) {
            System.out.println(an);
            boolean b = AnnotatedElementUtils.isAnnotated(clzz
                    ,"org.springframework.stereotype.Component");
            System.out.println(b);
            System.out.println(an.annotationType().getName());
            System.out.println(an.getClass().getName());
        }
    }

    public static void main(String []args) {
        SpringApplication springApplication = new SpringApplication(MainApp.class);

        springApplication.addListeners(new ApplicationListener<ApplicationEvent>() {
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.out.println("====== anonymous application listener # onApplicationEvent ");
            }
        });

        springApplication.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
            public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
                System.out.println("====== anonymous application context initializer # initialize");
            }
        });

        springApplication.setBanner(new ResourceBanner(new ClassPathResource("banner.txt")));

        springApplication.setBannerMode(Banner.Mode.CONSOLE);

        springApplication.run(args);

    }
}

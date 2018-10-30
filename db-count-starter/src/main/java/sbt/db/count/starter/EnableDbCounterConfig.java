package sbt.db.count.starter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DbCounterAutoConfiguration.class)
@Documented
public @interface EnableDbCounterConfig {
}

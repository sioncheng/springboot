package sbt.bookpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class StartupRunner2 implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        logger.info("spring...");
        logger.info(Boolean.toString(jdbcTemplate == null));
    }

    protected final Logger logger = LoggerFactory.getLogger(getClass());
}

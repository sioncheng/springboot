package sbt.bookpub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sbt.bookpub.repository.BookRepository;

import javax.sql.DataSource;

@Component
@Order(99)
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {
        logger.info("hello...");
        logger.info(Boolean.toString(dataSource == null));
        logger.info(String.format("Number of books: %d", bookRepository.count()));
        logger.info(String.format("book of isbn 124-f-567 : %s", bookRepository.findByIsbn("124-f-567")));
    }

    //@Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        logger.info(String.format("Number of books: %d", bookRepository.count()));
    }

    protected final Logger logger = LoggerFactory.getLogger(getClass());
}

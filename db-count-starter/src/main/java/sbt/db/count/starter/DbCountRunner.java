package sbt.db.count.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public class DbCountRunner implements CommandLineRunner {

    private Collection<CrudRepository> repositories;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public DbCountRunner(Collection<CrudRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void run(String... args) {
        repositories.forEach(crudRepository -> {
            logger.info(String.format("%s has %d entities", getRepositoryName(crudRepository), crudRepository.count()));
        });
    }


    private String getRepositoryName(CrudRepository repository) {
        for (Class intf :
                repository.getClass().getInterfaces()) {
            if (intf.getName().startsWith("sbt.bookpub.repository")) {
                return intf.getSimpleName();
            }
        }

        return "UnknownRepository";
    }
}

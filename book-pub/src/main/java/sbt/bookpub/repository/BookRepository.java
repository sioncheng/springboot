package sbt.bookpub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sbt.bookpub.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);
}

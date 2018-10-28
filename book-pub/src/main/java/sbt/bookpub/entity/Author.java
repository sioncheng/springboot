package sbt.bookpub.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    protected Author() {}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

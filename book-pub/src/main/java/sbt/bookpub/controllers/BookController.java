package sbt.bookpub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sbt.bookpub.editors.IsbnEditor;
import sbt.bookpub.model.Isbn;
import sbt.bookpub.entity.Book;
import sbt.bookpub.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Isbn isbn) {
        return bookRepository.findByIsbn(isbn.toString());
    }

    @RequestMapping(value = "/session")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }
}

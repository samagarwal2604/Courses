package com.example.bookInventory.controller;

import com.example.bookInventory.model.Book;
import com.example.bookInventory.requestdto.RequestDto;
import com.example.bookInventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.awt.print.Book;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
public class BookController {

    @Autowired
    public BookService bookservice;

    @PostMapping("/book")
    public Book Create(@RequestBody RequestDto requestdto)
    {
        return bookservice.create(requestdto);
    }

    @GetMapping("/book/all")
    public List<Book> getAll()
    {

        return bookservice.getAll();
    }

    @GetMapping(value= "/book/{id}")
        public Book getById(@PathVariable("id") int id)
        {

            return bookservice.getById(id);
        }

    @GetMapping(value = "/book/country/{authorCountry}")
    public List<Book> getByAuthorCountry(@PathVariable("authorCountry") String authorCountry)
    {
        return bookservice.getByAuthorCountry(authorCountry);
    }
}

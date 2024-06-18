package com.example.bookInventory.service;

import com.example.bookInventory.model.Book;
import com.example.bookInventory.repository.BookRepository;
import com.example.bookInventory.requestdto.RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {

    @Autowired
    public BookRepository bookrepository;
    public Book create(RequestDto requestdto)
    {
        Book book=requestdto.to();
        return bookrepository.save(book);
    }
    public List<Book> getAll()
    {
        return bookrepository.findAll();
    }
    public Book getById(Integer id)
    {
        return this.bookrepository
                .findById(id)
                .orElse(null);
    }


    public List<Book> getByAuthorCountry(String authorCountry)
    {
        return this.bookrepository
                .findByAuthorCountry(authorCountry);
    }
}

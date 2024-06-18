package com.example.bookInventory.repository;

import com.example.bookInventory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT b FROM Book b WHERE b.authorCountry = :authorCountry")
    public List<Book> findByAuthorCountry(@Param(value = "authorCountry") String authorCountry);
}

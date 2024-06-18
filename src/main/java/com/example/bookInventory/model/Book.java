package com.example.bookInventory.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity  // this annotation convert this class to sql table
@Table(name = "my_book") // this annotation is to change the name of sql table by default the name of table is same as class name
public class Book {

    @Id // this annotation is to name this field primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment annotation
    private int id;

    @Column(name = "book_name", nullable = false, length = 50) // to change the name of column
    private String name;

//    Integer => null , int => 0

    @Column(nullable = false)
    private String authorName;

    @Enumerated()  //we have to tell hibernate that which datatype has to be use so there are 2 options in @Enumerated 1.ORDINAL(numbers 1,2,3,4) 2. string
    private Genre genre;

    private String authorCountry;

    private String authorEmail;

    @CreationTimestamp // this annotation is from hibernate while other annotations are from jakarta
    /**
     * the reason for this annotation from hibernate is :-
     * normaly the request first goes to jakarta then to hibernate so there can be a delay therefore this annotation
     * present in hibernate to reduce the time delay
     * in good company's we use stored procedure we just update the timestamp in database level
     * */
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
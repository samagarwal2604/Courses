package com.example.bookInventory.requestdto;

import com.example.bookInventory.model.Book;
import com.example.bookInventory.model.Genre;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {


    private String name;

    private String authorName;

    @NotNull
    private Genre genre;

    private String authorCountry;

    private String authorEmail;

    public Book to(){
        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .authorEmail(this.authorEmail)
                .authorName(this.authorName)
                .authorCountry(this.authorCountry)
                .createdOn(new Date())
                .updatedOn(new Date())
                .build();
    }
}

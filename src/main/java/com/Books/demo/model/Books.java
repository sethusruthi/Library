package com.Books.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer bookId;
    @Column(name = "book_name", nullable = false)
    private String bookName;
    @Column(name = "author_id", nullable = false)
    private Integer authorId;
    private Double price;
    private String genre;

}

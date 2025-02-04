package com.Books.demo.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.*;


import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "rating")
    private String rating;

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Reviews> reviews;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @JsonBackReference
    private Authors authors;

    public void setAuthor(Authors authors) {
        this.authors = authors;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Different column name
    private Users author;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    @JsonBackReference
    private Librarians librarian;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<PurchasedBooks> purchasedByUsers;


}

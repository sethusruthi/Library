package com.Books.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Books> books;
    // One author can have many reviews
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Reviews> reviews = new ArrayList<>();
}




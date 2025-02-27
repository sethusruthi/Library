package com.Books.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    @JsonManagedReference(value = "author-books")
    @JsonIgnore
    private List<Books> books;


}


//package com.Books.demo.model;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Authors {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "author_id", nullable = false)
//    private Integer Id;
//    @Column(name = "first_name", nullable = false, length = 45)
//    private String name;
//    @Column(name="email",nullable = false)
//    private String email;
//    @OneToMany(mappedBy = "authors",cascade = CascadeType.ALL,orphanRemoval = true)
//    @JsonManagedReference
//    private List<Books> books;
//
//
//
//}

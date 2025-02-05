package com.Books.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "librarians")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarians {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Books> managedBooks = new ArrayList<>();

    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Users> managedUsers = new ArrayList<>();


}

package com.Books.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "librarians")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Librarians {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL)
    private List<Books> managedBooks = new ArrayList<>();

    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL)
    private List<Users> managedUsers = new ArrayList<>();


}

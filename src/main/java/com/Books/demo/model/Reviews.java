
package com.Books.demo.model;
import com.Books.demo.model.Books;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Integer id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "rating", nullable = false)
    private double rating;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @JsonBackReference
    private Books books;


//    @Column(name = "user", nullable = false)
//    private String user;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(name = "author_id")  // Foreign key column in Review table
    private Authors author;

}
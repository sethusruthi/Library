package com.Books.demo.DTO;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class BookRequestDTO {
    @NotBlank(message = "Title is mandatory and cannot be empty")
    private String title;
    @NotNull(message = "Price is mandatory")
    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;
    private String description;
    private String coverImage;
    @NotNull(message = "AuthorId is Mandatory")
    private Integer authorId;
    private Integer librarianId;
}

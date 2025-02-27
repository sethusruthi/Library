package com.Books.demo.DTO;

import lombok.Data;

@Data
public class BulkBookUploadDTO {
    private String title;
    private Double price;
    private String description;
    private String coverImage;
    private Integer authorId;
    private Integer librarianId;
}

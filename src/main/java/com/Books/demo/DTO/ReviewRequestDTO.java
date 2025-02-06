package com.Books.demo.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRequestDTO {
    @NotBlank(message = "Comment is mandatory and cannot be empty")
    private String comment;
    @NotNull(message = "Rating is mandatory and cannot be empty")
    @Min(value = 0, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot be more than 5")
    private double rating;
    @NotNull(message = "UserId is mandatory and cannot be empty")
    private Integer userId;

}

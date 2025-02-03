package com.Books.demo.DTO;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class BulkUploadResponse {
    private int totalBooks;
    private int successCount;
    private int failureCount;
    private List<String> errors;
}

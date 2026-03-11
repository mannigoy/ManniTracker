package com.Gcash.ManniTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PdfUploadResponseDTO {
    private UUID uploadId;
    private String fileName;
    private String status;
    private int totalParsed;
    private String message;
}
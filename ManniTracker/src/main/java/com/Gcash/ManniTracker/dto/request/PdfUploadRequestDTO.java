package com.Gcash.ManniTracker.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PdfUploadRequestDTO {
    private MultipartFile file;
    private String password;
}
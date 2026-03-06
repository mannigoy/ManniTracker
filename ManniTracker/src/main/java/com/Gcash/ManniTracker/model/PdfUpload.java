package com.Gcash.ManniTracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "pdf_uploads")
public class PdfUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "file_name", length = 255)
    private String fileName;

    @Column(name = "storage_path")
    private String storagePath;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UploadStatus status = UploadStatus.PENDING;

    @Column(name = "uploaded_at", updatable = false)
    private LocalDateTime uploadedAt;

    public enum UploadStatus {
        PENDING, PARSED, FAILED
    }

    @PrePersist
    protected void onCreate() {
        uploadedAt = LocalDateTime.now();
    }
}
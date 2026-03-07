package com.Gcash.ManniTracker.repository;

import com.Gcash.ManniTracker.model.PdfUpload;
import com.Gcash.ManniTracker.model.PdfUpload.UploadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface PdfUploadRepository extends JpaRepository<PdfUpload, UUID> {

    // Get all uploads for a user
    List<PdfUpload> findByUserId(UUID userId);

    // Get uploads by status (pending, parsed, failed)
    List<PdfUpload> findByUserIdAndStatus(UUID userId, UploadStatus status);
}
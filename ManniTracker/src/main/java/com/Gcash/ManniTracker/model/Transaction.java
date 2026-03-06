package com.Gcash.ManniTracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdf_upload_id")
    private PdfUpload pdfUpload;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionType type;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "reference_no", length = 100)
    private String referenceNo;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public enum TransactionType {
        SENT, RECEIVED
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
package com.Gcash.ManniTracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "monthly_summaries")
public class MonthlySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "total_spent", precision = 10, scale = 2)
    private BigDecimal totalSpent = BigDecimal.ZERO;

    @Column(name = "total_received", precision = 10, scale = 2)
    private BigDecimal totalReceived = BigDecimal.ZERO;

    @Column(name = "computed_at")
    private LocalDateTime computedAt;

    @PrePersist
    @PreUpdate
    protected void onCompute() {
        computedAt = LocalDateTime.now();
    }
}
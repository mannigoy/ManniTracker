package com.Gcash.ManniTracker.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TransactionResponseDTO {
    private UUID id;
    private String description;
    private BigDecimal amount;
    private String type;
    private String categoryName;
    private String categoryIcon;
    private LocalDate transactionDate;
    private String referenceNo;
}
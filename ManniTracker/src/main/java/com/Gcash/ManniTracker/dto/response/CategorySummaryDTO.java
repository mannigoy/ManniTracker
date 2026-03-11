package com.Gcash.ManniTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CategorySummaryDTO {
    private String categoryName;
    private String categoryIcon;
    private String categoryColor;
    private BigDecimal totalSpent;
    private int transactionCount;
}
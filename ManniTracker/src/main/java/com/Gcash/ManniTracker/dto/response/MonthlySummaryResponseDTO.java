package com.Gcash.ManniTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MonthlySummaryResponseDTO {
    private int month;
    private int year;
    private BigDecimal totalSpent;
    private BigDecimal totalReceived;
    private BigDecimal netBalance;
}

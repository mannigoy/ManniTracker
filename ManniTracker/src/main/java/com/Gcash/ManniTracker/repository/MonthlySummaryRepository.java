package com.Gcash.ManniTracker.repository;

import com.Gcash.ManniTracker.model.MonthlySummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MonthlySummaryRepository extends JpaRepository<MonthlySummary, UUID> {

    // Get all summaries for a user
    List<MonthlySummary> findByUserId(UUID userId);

    // Get specific month summary
    Optional<MonthlySummary> findByUserIdAndMonthAndYear(
            UUID userId, int month, int year
    );

    // Get all summaries for a year
    List<MonthlySummary> findByUserIdAndYear(UUID userId, int year);
}

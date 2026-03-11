package com.Gcash.ManniTracker.repository;

import com.Gcash.ManniTracker.model.Transaction;
import com.Gcash.ManniTracker.model.Transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    // Get all transactions for a user
    List<Transaction> findByUserId(UUID userId);

    // Get sent or received transactions
    List<Transaction> findByUserIdAndType(UUID userId, TransactionType type);

    // Get transactions by category
    List<Transaction> findByUserIdAndCategoryId(UUID userId, UUID categoryId);

    // Get transactions by month and year
    // Get transactions by month and year
    @Query("SELECT t FROM Transaction t " +
            "WHERE t.user.id = :userId " +
            "AND FUNCTION('MONTH', t.transactionDate) = :month " +
            "AND FUNCTION('YEAR', t.transactionDate) = :year")
    List<Transaction> findByUserIdAndMonthAndYear(
            @Param("userId") UUID userId,
            @Param("month") int month,
            @Param("year") int year
    );
    
    // Get total spent per category for a user
    @Query("SELECT t.category.name, SUM(t.amount) FROM Transaction t " +
            "WHERE t.user.id = :userId AND t.type = 'SENT' " +
            "GROUP BY t.category.name")
    List<Object[]> getTotalSpentByCategory(@Param("userId") UUID userId);

    // Get total spent for a specific month
    @Query("SELECT SUM(t.amount) FROM Transaction t " +
            "WHERE t.user.id = :userId " +
            "AND t.type = 'SENT' " +
            "AND MONTH(t.transactionDate) = :month " +
            "AND YEAR(t.transactionDate) = :year")
    BigDecimal getTotalSpentByMonth(
            @Param("userId") UUID userId,
            @Param("month") int month,
            @Param("year") int year
    );

    // Get total received for a specific month
    @Query("SELECT SUM(t.amount) FROM Transaction t " +
            "WHERE t.user.id = :userId " +
            "AND t.type = 'RECEIVED' " +
            "AND MONTH(t.transactionDate) = :month " +
            "AND YEAR(t.transactionDate) = :year")
    BigDecimal getTotalReceivedByMonth(
            @Param("userId") UUID userId,
            @Param("month") int month,
            @Param("year") int year
    );
}
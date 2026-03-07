package com.Gcash.ManniTracker.repository;

import com.Gcash.ManniTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    // Get all default categories
    List<Category> findByIsDefaultTrue();

    // Get all categories for a specific user
    List<Category> findByUserId(UUID userId);

    // Get both default + user's own categories
    List<Category> findByUserIdOrIsDefaultTrue(UUID userId);
}
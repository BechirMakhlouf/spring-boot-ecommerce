package com.bayi.ecommerce.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bayi.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
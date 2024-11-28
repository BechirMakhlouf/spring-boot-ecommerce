package com.bayi.ecommerce.repository;

import com.bayi.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

  @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
  List<Product> getProductsByCategory(@Param("categoryId") UUID categoryId);

  @Query("SELECT p FROM Product p WHERE LOWER(p.designation) LIKE LOWER(CONCAT('%', :designation, '%'))")
  List<Product> searchByDesignation(@Param("designation") String designation);
}
package com.bayi.ecommerce.entity;

import java.util.Set;
import java.util.UUID;

import com.bayi.ecommerce.dto.CategoryDTO;
import com.bayi.ecommerce.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Category
 */
@NoArgsConstructor
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Getter
  @Setter
  UUID id;

  @Getter
  @Setter
  String name;

  @Getter
  @Setter
  @ManyToMany(mappedBy = "categories")
  private Set<Product> products;

  public CategoryDTO toDTO() {
    CategoryDTO dto = new CategoryDTO();
    dto.setId(this.id);
    dto.setName(this.name);
    return dto;
  }
}

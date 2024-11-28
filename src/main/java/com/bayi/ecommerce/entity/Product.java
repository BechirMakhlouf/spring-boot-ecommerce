package com.bayi.ecommerce.entity;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.bayi.ecommerce.dto.CategoryDTO;
import com.bayi.ecommerce.dto.ProductDTO;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Getter
  @Setter
  private String designation;

  @Getter
  @Setter
  private double price;

  @Getter
  @Setter
  private String imageURL;

  @ManyToMany
  @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  @Getter
  @Setter
  private Set<Category> categories;

  public ProductDTO toDTO() {
    ProductDTO dto = new ProductDTO();
    dto.setId(this.id);
    dto.setDesignation(this.designation);
    dto.setPrice(this.price);
    dto.setImageURL(this.imageURL);
    dto.setCategories(this.categories.stream()
            .map(category -> {
              CategoryDTO categoryDTO = new CategoryDTO();
              categoryDTO.setId(category.getId());
              categoryDTO.setName(category.getName());
              return categoryDTO;
            }).collect(Collectors.toList()));
    return dto;
  }
}

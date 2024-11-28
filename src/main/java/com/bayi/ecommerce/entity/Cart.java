package com.bayi.ecommerce.entity;

import java.util.List;
import java.util.UUID;

import com.bayi.ecommerce.entity.Cart;

import jakarta.persistence.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter
// @Setter
// @NoArgsConstructor
@Entity
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  // private String designation;
  // private double price;
  // private String imageURL;

  // @ManyToMany(mappedBy = "cart")
  // List<Cart> Cart;
}

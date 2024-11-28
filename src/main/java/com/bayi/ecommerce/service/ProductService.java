package com.bayi.ecommerce.service;

import com.bayi.ecommerce.dto.ProductDTO;
import com.bayi.ecommerce.entity.Product;
import com.bayi.ecommerce.entity.Category;
import com.bayi.ecommerce.repository.CategoryRepository;
import com.bayi.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(UUID id) {
    return productRepository.findById(id);
  }

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public void deleteProduct(UUID id) {
    productRepository.deleteById(id);
  }

  public List<Product> getProductsByCategory(UUID categoryId) {
    return this.productRepository.getProductsByCategory(categoryId);
  }

  public Product addCategoryToProduct(UUID productId, UUID categoryId) {

    // Fetch the product and category
    Product product = productRepository
            .findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    Category category = categoryRepository
            .findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

    // Add category to product
    product.getCategories().add(category);

    // Maintain bidirectional relationship (optional)
    category.getProducts().add(product);
    // Save product (and by cascading, category might be updated if required)
    return productRepository.save(product);
  }

  public List<Product> getProductsByDesignation(String designation) {

    return productRepository.searchByDesignation(designation);
  }
}

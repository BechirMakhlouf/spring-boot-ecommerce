package com.bayi.ecommerce.controller;

import com.bayi.ecommerce.dto.CategoryDTO;
import com.bayi.ecommerce.dto.ProductDTO;
import com.bayi.ecommerce.entity.Category;
import com.bayi.ecommerce.entity.Product;
import com.bayi.ecommerce.service.CategoryService;
import com.bayi.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<CategoryDTO> getAllCategories() {
    return categoryService.getAllCategories().stream().map(Category::toDTO).toList();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable UUID id) {
    Optional<Category> category = categoryService.getCategoryById(id);

    return category.map(c -> ResponseEntity.ok(c.toDTO())).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Category createCategory(@RequestBody Category category) {
    System.out.println(category.toString());
    return categoryService.saveCategory(category);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/categories/{id}/products")
  public List<ProductDTO> getCategoryProducts(@PathVariable UUID id) {
    return this.productService.getProductsByCategory(id).stream().map(Product::toDTO).toList();
  }

}

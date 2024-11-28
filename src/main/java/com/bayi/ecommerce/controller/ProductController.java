package com.bayi.ecommerce.controller;

import com.bayi.ecommerce.dto.ProductDTO;
import com.bayi.ecommerce.service.CategoryService;
import com.bayi.ecommerce.entity.Product;
import com.bayi.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<ProductDTO> getAllProducts(@RequestParam(value= "designation", required = false) String designation) {
    if (designation == null || designation.isEmpty()) {
      return productService.getAllProducts().stream().map(Product::toDTO).toList();
    }
    return productService.getProductsByDesignation(designation).stream().map(Product::toDTO).toList();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID id) {
    Optional<Product> product = productService.getProductById(id);

    return product
            .map(p -> ResponseEntity.ok(p.toDTO())) // Produces ResponseEntity<ProductDTO>
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public List<ProductDTO> getProductsByDesignation(@RequestParam(value= "designation", required = false) String designation) {
    return productService.getProductsByDesignation(designation).stream().map(Product::toDTO).toList();
  }

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{productId}/categories/{categoryId}")
  public ResponseEntity<ProductDTO> addCategoryToProduct(
          @PathVariable UUID productId,
          @PathVariable UUID categoryId) {
    try {
      Product updatedProduct = productService.addCategoryToProduct(productId, categoryId);
      return ResponseEntity.ok(updatedProduct.toDTO());
    } catch (RuntimeException e) {
      System.out.printf(e.getMessage());
      return ResponseEntity.notFound().build();
    }
  }

}

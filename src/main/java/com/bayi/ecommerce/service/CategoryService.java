package com.bayi.ecommerce.service;

import com.bayi.ecommerce.entity.Category;
import com.bayi.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Optional<Category> getCategoryById(UUID id) {
    return categoryRepository.findById(id);
  }

  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  public void deleteCategory(UUID id) {
    categoryRepository.deleteById(id);
  }

}

package com.bayi.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
  @Getter
  @Setter
  private UUID id;

  @Getter
  @Setter
  private String name;
}

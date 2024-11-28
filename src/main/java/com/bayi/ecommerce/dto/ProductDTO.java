package com.bayi.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @Getter
    @Setter
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

    @Getter
    @Setter
    private List<CategoryDTO> categories;
}
package com.woyo.toko.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private int productId;
    private StoreDTO store;
    private CategoryDTO category;
    private String productName;
    private int stock;
    private int price;
    private String description;
    private String status;
}

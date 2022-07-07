package com.woyo.toko.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {
    private int storeId;
    private int categoryId;
    private String productName;
    private int stock;
    private int price;
    private String description;
    private String status;
}

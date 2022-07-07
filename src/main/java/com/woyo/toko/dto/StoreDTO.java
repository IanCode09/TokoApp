package com.woyo.toko.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreDTO {
    private int storeId;
    private String storeName;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeDescription;
}

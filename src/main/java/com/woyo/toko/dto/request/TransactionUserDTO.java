package com.woyo.toko.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionUserDTO {
    private int userId;
    private int productId;
    private int qty;
    private String shippingAddress;
}

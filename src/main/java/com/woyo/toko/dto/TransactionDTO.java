package com.woyo.toko.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {
    private int transactionId;
    private int userId;
    private int storeId;
    private int productId;
    private int qty;
    private int price;
    private int totalPrice;
    private String shippingAddress;
}

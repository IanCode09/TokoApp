package com.woyo.toko.model;

import java.time.LocalDateTime;

public interface CustomTransactionModel {
    int getTransactionId();
    int getUserId();
    String getFirstName();
    String getLastName();
    String getEmail();
    int getStoreId();
    String getStoreName();
    String getStorePhone();
    int getProductId();
    String getProductName();
    int getQty();
    int getPrice();
    int getTotalPrice();
    String getShippingAddress();
    LocalDateTime getCreatedAt();
}

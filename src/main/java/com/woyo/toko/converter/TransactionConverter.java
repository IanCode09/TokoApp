package com.woyo.toko.converter;

import com.woyo.toko.dto.TransactionDTO;
import com.woyo.toko.dto.TransactionDetailDTO;
import com.woyo.toko.model.CustomTransactionModel;
import com.woyo.toko.model.TransactionModel;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    public TransactionDetailDTO convertToDTO(CustomTransactionModel item) {
        TransactionDetailDTO transactionDetailDTO = new TransactionDetailDTO();
        transactionDetailDTO.setTransactionId(item.getTransactionId());
        transactionDetailDTO.setUserId(item.getUserId());
        transactionDetailDTO.setFirstName(item.getFirstName());
        transactionDetailDTO.setLastName(item.getLastName());
        transactionDetailDTO.setEmail(item.getEmail());
        transactionDetailDTO.setStoreId(item.getStoreId());
        transactionDetailDTO.setStoreName(item.getStoreName());
        transactionDetailDTO.setProductId(item.getProductId());
        transactionDetailDTO.setProductName(item.getProductName());
        transactionDetailDTO.setQty(item.getQty());
        transactionDetailDTO.setPrice(item.getPrice());
        transactionDetailDTO.setTotalPrice(item.getTotalPrice());
        transactionDetailDTO.setShippingAddress(item.getShippingAddress());
        transactionDetailDTO.setCreatedAt(item.getCreatedAt());

        return transactionDetailDTO;
    }

    public TransactionDTO convertToDTO(TransactionModel item) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(item.getTransactionId());
        transactionDTO.setUserId(item.getUserId());
        transactionDTO.setStoreId(item.getStoreId());
        transactionDTO.setProductId(item.getProductId());
        transactionDTO.setQty(item.getQty());
        transactionDTO.setPrice(item.getPrice());
        transactionDTO.setTotalPrice(item.getTotalPrice());
        transactionDTO.setShippingAddress(item.getShippingAddress());

        return transactionDTO;
    }
}

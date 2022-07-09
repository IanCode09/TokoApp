package com.woyo.toko.service;

import com.woyo.toko.dto.TransactionDTO;
import com.woyo.toko.dto.TransactionDetailDTO;
import com.woyo.toko.dto.request.TransactionUserDTO;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface TransactionService {
    List<TransactionDetailDTO> getAllTransactionByStoreId(int storeId, int page);
    List<TransactionDetailDTO> getAllTransactionByProductId(int productId, int page);
    List<TransactionDetailDTO> getAllTransactionStoreByMonth(int storeId, int month, int page);
    TransactionDTO userTransaction(TransactionUserDTO transactionUserDTO);
}

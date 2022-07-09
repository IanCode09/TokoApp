package com.woyo.toko.service.impl;

import com.woyo.toko.converter.TransactionConverter;
import com.woyo.toko.dto.TransactionDTO;
import com.woyo.toko.dto.TransactionDetailDTO;
import com.woyo.toko.dto.request.TransactionUserDTO;
import com.woyo.toko.model.ProductModel;
import com.woyo.toko.model.TransactionModel;
import com.woyo.toko.repository.ProductRepository;
import com.woyo.toko.repository.TransactionRepository;
import com.woyo.toko.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    public static final int COUNT_PER_PAGE = 2;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TransactionConverter transactionConverter;

    @Override
    public List<TransactionDetailDTO> getAllTransactionByStoreId(int storeId, int page) {
        if (page > 0) page = page - 1;
        Pageable pagination = PageRequest.of(page, COUNT_PER_PAGE);

        return transactionRepository.getAllTransactionByStoreId(storeId, pagination).stream()
                .map(transaction -> transactionConverter.convertToDTO(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDetailDTO> getAllTransactionByProductId(int productId, int page) {
        if (page > 0) page = page - 1;
        Pageable pagination = PageRequest.of(page, COUNT_PER_PAGE);

        return transactionRepository.getAllTransactionByProductId(productId, pagination).stream()
                .map(transaction -> transactionConverter.convertToDTO(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDetailDTO> getAllTransactionStoreByMonth(int storeId, int month, int page) {
        if (page > 0) page = page - 1;
        Pageable pagination = PageRequest.of(page, COUNT_PER_PAGE);

        return transactionRepository.getAllTransactionStoreByMonth(storeId, month, pagination).stream()
                .map(transaction -> transactionConverter.convertToDTO(transaction))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO userTransaction(TransactionUserDTO transactionUserDTO) {
        Optional<ProductModel> product = productRepository.findById(transactionUserDTO.getProductId());

        int totalPrice = transactionUserDTO.getQty() * product.get().getPrice();

        TransactionModel transaction = new TransactionModel();
        transaction.setUserId(transactionUserDTO.getUserId());
        transaction.setStoreId(product.get().getStore().getStoreId());
        transaction.setProductId(transactionUserDTO.getProductId());
        transaction.setQty(transactionUserDTO.getQty());
        transaction.setPrice(product.get().getPrice());
        transaction.setTotalPrice(totalPrice);
        transaction.setShippingAddress(transactionUserDTO.getShippingAddress());
        transaction.setCreatedAt(LocalDateTime.now());

        return transactionConverter.convertToDTO(transactionRepository.save(transaction));
    }
}

package com.woyo.toko.repository;

import com.woyo.toko.model.CustomTransactionModel;
import com.woyo.toko.model.TransactionModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {

    @Query(value = "SELECT ttr.transaction_id AS transactionId, ttr.user_id AS userId, tu.first_name AS firstName, tu.last_name AS lastName, tu.email AS email, " +
            "ttr.store_id AS storeId, ts.store_name AS storeName, ts.store_phone AS storePhone, ttr.product_id AS productId, tp.product_name AS productName, " +
            "ttr.qty AS qty, ttr.price AS price, ttr.total_price AS totalPrice, ttr.shipping_address AS shippingAddress, ttr.created_at AS createdAt " +
            "FROM tab_transaction AS ttr " +
            "INNER JOIN tab_user AS tu ON ttr.user_id = tu.user_id " +
            "INNER JOIN tab_store AS ts ON ttr.store_id = ts.store_id " +
            "INNER JOIN tab_product AS tp ON ttr.product_id = tp.product_id " +
            "WHERE ttr.store_id = :storeId ", nativeQuery = true)
    Slice<CustomTransactionModel> getAllTransactionByStoreId(int storeId, Pageable pageable);

    @Query(value = "SELECT ttr.transaction_id AS transactionId, ttr.user_id AS userId, tu.first_name AS firstName, tu.last_name AS lastName, tu.email AS email, " +
            "ttr.store_id AS storeId, ts.store_name AS storeName, ts.store_phone AS storePhone, ttr.product_id AS productId, tp.product_name AS productName, " +
            "ttr.qty AS qty, ttr.price AS price, ttr.total_price AS totalPrice, ttr.shipping_address AS shippingAddress, ttr.created_at AS createdAt " +
            "FROM tab_transaction AS ttr " +
            "INNER JOIN tab_user AS tu ON ttr.user_id = tu.user_id " +
            "INNER JOIN tab_store AS ts ON ttr.store_id = ts.store_id " +
            "INNER JOIN tab_product AS tp ON ttr.product_id = tp.product_id " +
            "WHERE ttr.product_id = :productId ", nativeQuery = true)
    Slice<CustomTransactionModel> getAllTransactionByProductId(int productId, Pageable pageable);

    @Query(value = "SELECT ttr.transaction_id AS transactionId, ttr.user_id AS userId, tu.first_name AS firstName, tu.last_name AS lastName, tu.email AS email, " +
            "ttr.store_id AS storeId, ts.store_name AS storeName, ts.store_phone AS storePhone, ttr.product_id AS productId, tp.product_name AS productName, " +
            "ttr.qty AS qty, ttr.price AS price, ttr.total_price AS totalPrice, ttr.shipping_address AS shippingAddress, ttr.created_at AS createdAt " +
            "FROM tab_transaction AS ttr " +
            "INNER JOIN tab_user AS tu ON ttr.user_id = tu.user_id " +
            "INNER JOIN tab_store AS ts ON ttr.store_id = ts.store_id " +
            "INNER JOIN tab_product AS tp ON ttr.product_id = tp.product_id " +
            "WHERE ttr.store_id = :storeId AND MONTH(ttr.created_at) = :month ", nativeQuery = true)
    Slice<CustomTransactionModel> getAllTransactionStoreByMonth(int storeId, int month, Pageable pageable);
}

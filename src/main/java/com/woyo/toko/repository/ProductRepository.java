package com.woyo.toko.repository;

import com.woyo.toko.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    @Query(value = "SELECT pm FROM ProductModel pm " +
            "WHERE pm.store.storeId = :storeId")
    List<ProductModel> findProductsByStore(int storeId);

    @Query(value = "SELECT pm FROM ProductModel pm " +
            "WHERE pm.productName LIKE %:keywords% ")
    List<ProductModel> searchProductByName(String keywords);
}

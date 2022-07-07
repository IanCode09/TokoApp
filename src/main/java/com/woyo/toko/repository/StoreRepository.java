package com.woyo.toko.repository;

import com.woyo.toko.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreModel, Integer> {
    Optional<StoreModel> findByStoreEmail(String email);
    Optional<StoreModel> findByStoreEmailAndStorePassword(String email, String password);
}

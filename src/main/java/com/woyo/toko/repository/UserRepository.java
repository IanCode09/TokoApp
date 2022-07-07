package com.woyo.toko.repository;

import com.woyo.toko.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByEmailAndPassword(String email, String password);
}

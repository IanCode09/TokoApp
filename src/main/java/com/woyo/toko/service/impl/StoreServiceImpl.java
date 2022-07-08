package com.woyo.toko.service.impl;

import com.woyo.toko.converter.StoreConverter;
import com.woyo.toko.dto.StoreDTO;
import com.woyo.toko.dto.request.StoreRequestDTO;
import com.woyo.toko.model.StoreModel;
import com.woyo.toko.repository.StoreRepository;
import com.woyo.toko.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreConverter storeConverter;

    @Override
    public StoreDTO register(StoreRequestDTO storeRequestDTO) {
        Optional<StoreModel> store = storeRepository.findByStoreEmail(storeRequestDTO.getStoreEmail());

        if (store.isPresent()) {
            return null;
        }

        StoreModel storeModel = new StoreModel();
        storeModel.setStoreName(storeRequestDTO.getStoreName());
        storeModel.setStoreAddress(storeRequestDTO.getStoreAddress());
        storeModel.setStorePhone(storeRequestDTO.getStorePhone());
        storeModel.setStoreEmail(storeRequestDTO.getStoreEmail());
        storeModel.setStorePassword(storeRequestDTO.getStorePassword());
        storeModel.setStoreDescription(storeRequestDTO.getStoreDescription());
        storeModel.setCreatedAt(LocalDateTime.now());

        return storeConverter.convertToDto(storeRepository.save(storeModel));
    }

    @Override
    public StoreDTO storeDetail(int storeId) {
        Optional<StoreModel> store = storeRepository.findById(storeId);

        if (store.isPresent()) {
            return storeConverter.convertToDto(store.get());
        }

        return null;
    }

    @Override
    public List<StoreDTO> getAllStore() {
        return storeRepository.findAll().stream()
                .map(store -> storeConverter.convertToDto(store))
                .collect(Collectors.toList());
    }
}

package com.woyo.toko.service;

import com.woyo.toko.dto.StoreDTO;
import com.woyo.toko.dto.request.StoreRequestDTO;

import java.util.List;

public interface StoreService {
    StoreDTO register(StoreRequestDTO storeRequestDTO);
    StoreDTO storeDetail(int storeId);
    List<StoreDTO> getAllStore();
}

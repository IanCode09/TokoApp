package com.woyo.toko.converter;

import com.woyo.toko.dto.StoreDTO;
import com.woyo.toko.model.StoreModel;
import org.springframework.stereotype.Component;

@Component
public class StoreConverter {

    public StoreDTO convertToDto(StoreModel item) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreId(item.getStoreId());
        storeDTO.setStoreName(item.getStoreName());
        storeDTO.setStoreAddress(item.getStoreAddress());
        storeDTO.setStorePhone(item.getStorePhone());
        storeDTO.setStoreEmail(item.getStoreEmail());
        storeDTO.setStoreDescription(item.getStoreDescription());

        return storeDTO;
    }
}

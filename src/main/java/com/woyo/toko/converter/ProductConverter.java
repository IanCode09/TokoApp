package com.woyo.toko.converter;

import com.woyo.toko.dto.ProductDTO;
import com.woyo.toko.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private StoreConverter storeConverter;
    @Autowired
    private CategoryConverter categoryConverter;

    public ProductDTO convertToDTO(ProductModel item) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(item.getProductId());
        productDTO.setStore(storeConverter.convertToDto(item.getStore()));
        productDTO.setCategory(categoryConverter.convertToDTO(item.getCategory()));
        productDTO.setProductName(item.getProductName());
        productDTO.setStock(item.getStock());
        productDTO.setPrice(item.getPrice());
        productDTO.setDescription(item.getDescription());
        productDTO.setStatus(item.getStatus());

        return productDTO;
    }
}

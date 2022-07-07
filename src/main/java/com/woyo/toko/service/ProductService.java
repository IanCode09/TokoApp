package com.woyo.toko.service;

import com.woyo.toko.dto.ProductDTO;
import com.woyo.toko.dto.request.ProductRequestDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductDTO getProductDetail(int productId);
    List<ProductDTO> getProductsByStoreId(int storeId);
    List<ProductDTO> searchProductByName(String keywords);
}

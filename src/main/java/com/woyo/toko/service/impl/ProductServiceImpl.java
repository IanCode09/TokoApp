package com.woyo.toko.service.impl;

import com.woyo.toko.converter.ProductConverter;
import com.woyo.toko.dto.ProductDTO;
import com.woyo.toko.dto.request.ProductRequestDTO;
import com.woyo.toko.model.ProductModel;
import com.woyo.toko.repository.CategoryRepository;
import com.woyo.toko.repository.ProductRepository;
import com.woyo.toko.repository.StoreRepository;
import com.woyo.toko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductRequestDTO productRequestDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setStore(storeRepository.findById(productRequestDTO.getStoreId()).get());
        productModel.setCategory(categoryRepository.findById(productRequestDTO.getCategoryId()).get());
        productModel.setProductName(productRequestDTO.getProductName());
        productModel.setStock(productRequestDTO.getStock());
        productModel.setPrice(productRequestDTO.getPrice());
        productModel.setDescription(productRequestDTO.getDescription());
        productModel.setStatus(productRequestDTO.getStatus());
        productModel.setCreatedAt(LocalDateTime.now());

        return productConverter.convertToDTO(productRepository.save(productModel));
    }

    @Override
    public ProductDTO getProductDetail(int productId) {
        Optional<ProductModel> product = productRepository.findById(productId);

        if (product.isPresent()) {
            return productConverter.convertToDTO(product.get());
        } else {
            return null;
        }
    }

    @Override
    public List<ProductDTO> getProductsByStoreId(int storeId) {
        List<ProductModel> products = productRepository.findProductsByStore(storeId);
        return products.stream().map(product -> productConverter.convertToDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchProductByName(String keywords) {
        List<ProductModel> products = productRepository.searchProductByName(keywords);
        return products.stream().map(product -> productConverter.convertToDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(int productId, ProductRequestDTO productRequestDTO) {
        Optional<ProductModel> product = productRepository.findById(productId);

        if (product.isPresent()) {
            product.get().setCategory(categoryRepository.findById(productRequestDTO.getCategoryId()).get());
            product.get().setProductName(productRequestDTO.getProductName());
            product.get().setStock(productRequestDTO.getStock());
            product.get().setPrice(productRequestDTO.getPrice());
            product.get().setDescription(productRequestDTO.getDescription());
            product.get().setStatus(productRequestDTO.getStatus());

            return productConverter.convertToDTO(productRepository.save(product.get()));
        } else {
            return null;
        }
    }
}

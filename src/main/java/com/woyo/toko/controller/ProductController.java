package com.woyo.toko.controller;

import com.woyo.toko.dto.ProductDTO;
import com.woyo.toko.dto.request.ProductRequestDTO;
import com.woyo.toko.response.DataResponse;
import com.woyo.toko.response.HandlerResponse;
import com.woyo.toko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public void createProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody ProductRequestDTO productRequestDTO) throws IOException {

        ProductDTO productDTO = productService.createProduct(productRequestDTO);

        if (productDTO != null) {
            DataResponse<ProductDTO> data = new DataResponse<>();
            data.setData(productDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseBadRequest(response, 400, "Something wrong");
        }
    }

    @GetMapping("/{productId}")
    public void getProductDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable int productId) throws IOException {

        ProductDTO productDTO = productService.getProductDetail(productId);

        if (productDTO != null) {
            DataResponse<ProductDTO> data = new DataResponse<>();
            data.setData(productDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseNotFound(response, 404, "Product not found");
        }
    }

    @GetMapping("/store/{storeId}")
    public void getProductByStoreId(HttpServletRequest request, HttpServletResponse response, @PathVariable int storeId) throws IOException {

        List<ProductDTO> productDTOList = productService.getProductsByStoreId(storeId);
        DataResponse<List<ProductDTO>> data = new DataResponse<>();
        data.setData(productDTOList);
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @GetMapping("/search")
    public void searchProductByName(HttpServletRequest request, HttpServletResponse response, @RequestParam String keywords) throws IOException {

        List<ProductDTO> productDTOList = productService.searchProductByName(keywords);
        DataResponse<List<ProductDTO>> data = new DataResponse<>();
        data.setData(productDTOList);
        HandlerResponse.responseSuccessWithData(response, data);
    }
}

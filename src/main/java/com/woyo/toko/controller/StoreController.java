package com.woyo.toko.controller;

import com.woyo.toko.dto.StoreDTO;
import com.woyo.toko.dto.request.StoreRequestDTO;
import com.woyo.toko.response.DataResponse;
import com.woyo.toko.response.HandlerResponse;
import com.woyo.toko.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/register")
    public void storeRegister(HttpServletRequest request, HttpServletResponse response,
                              @RequestBody StoreRequestDTO storeRequestDTO) throws IOException {

        StoreDTO storeDTO = storeService.register(storeRequestDTO);

        if (storeDTO != null) {
            DataResponse<StoreDTO> data = new DataResponse<>();
            data.setData(storeDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseBadRequest(response, 400, "Something wrong or email exists");
        }
    }

    @GetMapping("")
    public void getAllStore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<StoreDTO> storeDTOList = storeService.getAllStore();
        DataResponse<List<StoreDTO>> data = new DataResponse<>();
        data.setData(storeDTOList);
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @GetMapping("/{storeId}")
    public void getStoreDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable int storeId) throws IOException {

        StoreDTO storeDTO = storeService.storeDetail(storeId);

        if (storeDTO != null) {
            DataResponse<StoreDTO> data = new DataResponse<>();
            data.setData(storeDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseNotFound(response, 404, "Store not found");
        }
    }
}

package com.woyo.toko.controller;

import com.woyo.toko.dto.TransactionDTO;
import com.woyo.toko.dto.TransactionDetailDTO;
import com.woyo.toko.dto.request.TransactionUserDTO;
import com.woyo.toko.response.DataResponse;
import com.woyo.toko.response.HandlerResponse;
import com.woyo.toko.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/store/list")
    public void getAllTransactionStore(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam int storeId, @RequestParam int page) throws IOException {

        List<TransactionDetailDTO> transactionDTOSlice = transactionService.getAllTransactionByStoreId(storeId, page);
        DataResponse<List<TransactionDetailDTO>> data = new DataResponse<>();
        data.setData(transactionDTOSlice);
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @GetMapping("/product/list")
    public void getAllTransactionByProductId(HttpServletRequest request, HttpServletResponse response,
                                             @RequestParam int productId, @RequestParam int page) throws IOException {

        List<TransactionDetailDTO> transactionDetailDTOList = transactionService.getAllTransactionByProductId(productId, page);
        DataResponse<List<TransactionDetailDTO>> data = new DataResponse<>();
        data.setData(transactionDetailDTOList);
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @GetMapping("/store/per-month/list")
    public void getAllTransactionStoreFilterByMonth(HttpServletRequest request, HttpServletResponse response,
                                             @RequestParam int storeId, @RequestParam int month, @RequestParam int page) throws IOException {

        List<TransactionDetailDTO> transactionDetailDTOList = transactionService.getAllTransactionStoreByMonth(storeId, month, page);
        DataResponse<List<TransactionDetailDTO>> data = new DataResponse<>();
        data.setData(transactionDetailDTOList);
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @PostMapping("/user")
    public void userTransaction(HttpServletRequest request, HttpServletResponse response, @RequestBody TransactionUserDTO transactionUserDTO) throws IOException {

        TransactionDTO transactionDTO = transactionService.userTransaction(transactionUserDTO);

        if (transactionDTO != null) {
            DataResponse<TransactionDTO> data = new DataResponse<>();
            data.setData(transactionDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseBadRequest(response, 400, "Something wrong");
        }
    }
}

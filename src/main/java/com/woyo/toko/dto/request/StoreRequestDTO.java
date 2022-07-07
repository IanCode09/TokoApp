package com.woyo.toko.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class StoreRequestDTO {
    private String storeName;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storePassword;
    private String storeDescription;
}

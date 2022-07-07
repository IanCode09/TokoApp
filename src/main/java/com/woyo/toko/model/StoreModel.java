package com.woyo.toko.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tab_store")
@Getter
@Setter
@NoArgsConstructor
public class StoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id ")
    private int storeId;
    @Column(name = "store_name")
    private String storeName;
    @Column(name = "store_address", columnDefinition = "TEXT")
    private String storeAddress;
    @Column(name = "store_phone")
    private String storePhone;
    @Column(name = "store_email")
    private String storeEmail;
    @Column(name = "store_password")
    private String storePassword;
    @Column(name = "store_description", columnDefinition = "TEXT")
    private String storeDescription;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "store")
    private List<ProductModel> products;

}

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

@Entity
@Table(name = "tab_product")
@Getter
@Setter
@NoArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private StoreModel store;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryModel category;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "stock")
    private int stock;
    @Column(name = "price")
    private int price;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "status", columnDefinition = "enum('Y','N')")
    private String status;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

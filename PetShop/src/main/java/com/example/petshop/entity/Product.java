package com.example.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "ProductID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "ProductName", nullable = false)
    private String productName;

    @NotNull
    @Column(name = "Price", nullable = false)
    private Integer price;

    @Size(max = 255)
    @NotNull
    @Column(name = "Photo", nullable = false)
    private String photo;

    @NotNull
    @Column(name = "Available", nullable = false)
    private Boolean available = false;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "ProductDescription", nullable = false)
    private String productDescription;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductCategoryID", nullable = false)
    private ProductCategory productCategoryID;

    @OneToMany(mappedBy = "productID")
    private Set<OrderProductDetail> orderProductDetails = new LinkedHashSet<>();

}
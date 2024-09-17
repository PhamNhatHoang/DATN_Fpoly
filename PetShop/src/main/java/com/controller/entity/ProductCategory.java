package com.controller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class ProductCategory {
    @Id
    @Column(name = "ProductCategoryID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "ProductCategoryName", nullable = false)
    private String productCategoryName;

    @Size(max = 255)
    @NotNull
    @Column(name = "Photo", nullable = false)
    private String photo;

    @OneToMany(mappedBy = "productCategoryID")
    private Set<Product> products = new LinkedHashSet<>();

}
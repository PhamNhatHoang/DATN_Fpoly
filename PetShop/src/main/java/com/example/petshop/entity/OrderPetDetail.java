package com.example.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "OrderPetDetails")
public class OrderPetDetail {
    @Id
    @Column(name = "OrderPetDetailID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OrderID", nullable = false)
    private Order orderID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PetID", nullable = false)
    private Pet petID;

    @NotNull
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "Price", nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "orderPetDetailID")
    private Set<Voucher> vouchers = new LinkedHashSet<>();

}
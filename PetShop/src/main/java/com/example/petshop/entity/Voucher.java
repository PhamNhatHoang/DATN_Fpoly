package com.example.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Voucher {
    @Id
    @Column(name = "VoucherID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    @NotNull
    @Column(name = "Discount", nullable = false)
    private Integer discount;

    @NotNull
    @Column(name = "ExpiryDate", nullable = false)
    private LocalDate expiryDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserName", nullable = false)
    private User userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderPetDetailID")
    private OrderPetDetail orderPetDetailID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderProductDetailID")
    private OrderProductDetail orderProductDetailID;

}
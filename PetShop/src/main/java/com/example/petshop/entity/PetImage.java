package com.example.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PetImage {
    @Id
    @Column(name = "PetImageID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "Photo", nullable = false)
    private String photo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PetID", nullable = false)
    private Pet petID;

}
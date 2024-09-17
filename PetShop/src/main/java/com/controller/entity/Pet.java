package com.controller.entity;

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
@Table(name = "Pets")
public class Pet {
    @Id
    @Size(max = 1)
    @Column(name = "PetID", nullable = false, length = 1)
    private String petID;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "Breed", nullable = false)
    private String breed;

    @NotNull
    @Column(name = "Age", nullable = false)
    private Integer age;

    @NotNull
    @Column(name = "Gender", nullable = false)
    private Boolean gender = false;

    @NotNull
    @Column(name = "Price", nullable = false)
    private Integer price;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "PetDescription", nullable = false)
    private String petDescription;

    @Size(max = 255)
    @NotNull
    @Column(name = "Photo", nullable = false)
    private String photo;

    @NotNull
    @Column(name = "Available", nullable = false)
    private Boolean available = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PetCategoryID", nullable = false)
    private PetCategory petCategoryID;

    @OneToMany(mappedBy = "petID")
    private Set<OrderPetDetail> orderPetDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "petID")
    private Set<PetFamous> petFamous = new LinkedHashSet<>();

    @OneToMany(mappedBy = "petID")
    private Set<PetHair> petHairs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "petID")
    private Set<PetImage> petImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "petID")
    private Set<Review> reviews = new LinkedHashSet<>();

}
package com.controller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rating {
    @Id
    @Column(name = "RatingID", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "Number", nullable = false)
    private Integer number;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ReviewID", nullable = false)
    private Review reviewID;

}
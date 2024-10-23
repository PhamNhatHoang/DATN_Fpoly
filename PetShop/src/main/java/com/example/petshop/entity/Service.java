package com.example.petshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Table(name = "Service")
@Entity
@Data
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceID", nullable = false)
    private Integer serviceID;

    @Nationalized
    @Column(name = "ServiceName", nullable = false, length = 255)
    private String serviceName;

    @Column(name = "Price", nullable = false)
    private int price;

    @Nationalized
    @Column(name = "Description", nullable = false, length = 255)
    private String description;

    // Constructors, getters, setters
    public Service() {
    }

    public Service(String serviceName, int price, String description) {
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
    }
}

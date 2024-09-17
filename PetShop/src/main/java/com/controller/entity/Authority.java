package com.controller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Authorities")
public class Authority {

    @Id
    @Column(name = "AuthID")
    private Integer authID;

    @Column(name = "RoleName")
    private String roleName;

    @OneToMany(mappedBy = "authority")
    private List<User> users; 

}

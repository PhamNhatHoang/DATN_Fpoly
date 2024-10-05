package com.controller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference
    private List<User> users;

}

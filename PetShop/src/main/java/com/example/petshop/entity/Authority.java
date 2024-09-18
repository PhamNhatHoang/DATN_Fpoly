package com.example.petshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@Entity
@Table(name = "Authorities")
public class Authority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return roleName;
    }

    @Id
    @Column(name = "AuthID")
    private Integer authID;

    @Column(name = "RoleName")
    private String roleName;

    @OneToMany(mappedBy = "authority")
    private List<User> users;

}

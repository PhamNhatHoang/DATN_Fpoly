package com.controller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

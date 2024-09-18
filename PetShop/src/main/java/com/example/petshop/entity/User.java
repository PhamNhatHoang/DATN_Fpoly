package com.example.petshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @Column(name = "UserName")
    private String username;

    @Column(name = "UserPassword")
    private String userPassword;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "UserAddress")
    private String userAddress;

    @ManyToOne
    @JoinColumn(name = "AuthID")
    private Authority authority;

    @NotNull
    @Column(name = "Enable", nullable = false)
    private Boolean enable = false;

    @Size(max = 200)
    @NotNull
    @Column(name = "ActiveToken", nullable = false, length = 200)
    private String activeToken;

    @NotNull
    @Column(name = "DateCreated", nullable = false)
    private Instant dateCreated;

    @OneToMany(mappedBy = "userName")
    private Set<BookingService> bookingServices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userName")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userName")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userName")
    private Set<Voucher> vouchers = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(authority);
    }
    @Override
    public String getPassword() {
        return userPassword;
    }
}

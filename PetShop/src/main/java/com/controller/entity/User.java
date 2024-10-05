package com.controller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "UserName")
    private String userName;
    
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
    
    @Column(name = "Enable")
    private boolean enable ;
    
    @Column(name = "ActiveToken")
    private String activeToken;
    
    @Column(name = "DateCreated")
    private Date dateCreated ;

    @ManyToOne
    @JoinColumn(name = "AuthID")
    @JsonBackReference
    private Authority authority;

}

//package com.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Column;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "Users")
//public class User {
//
//    @Id
//    @Column(name = "UserName")
//    private String username;
//
//    @Column(name = "UserPassword")
//    private String userPassword;
//
//    @Column(name = "FullName")
//    private String fullName;
//
//    @Column(name = "Email")
//    private String email;
//
//    @Column(name = "PhoneNumber")
//    private String phoneNumber;
//
//    @Column(name = "UserAddress")
//    private String userAddress;
//
//    @ManyToOne
//    @JoinColumn(name = "AuthID")
//    private Authority authority;
//
//}

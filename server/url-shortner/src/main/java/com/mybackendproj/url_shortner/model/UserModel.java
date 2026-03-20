package com.mybackendproj.url_shortner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "User_table")
public class UserModel{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    String userName;
    String email;
    String password;

    // Getter and Setter
}
package com.moviesite.movieProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, length = 20,nullable = false)
    private String userName;

    //@JsonIgnore
    @Column(name = "password" ,length = 20,nullable = false)
    private String password;

    @Column(name = "first_name",length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50,nullable = false)
    private String lastName;

    @Column(name = "user_role")
    private UserRole userRole=UserRole.USER;


    @JsonIgnore
    @Column(name = "mail",unique = true, length = 50,nullable = false)
    private String mail;

     @JsonIgnore
     @Column(name = "registraiton_date",length = 50)
     private String registrationDate;//=LocalDate.now();





}

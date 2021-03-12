package com.moviesite.movieProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moviesite.movieProject.shared.LocalDateNow;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UserCreatedDto {

    @NotNull(message = "First Name cannot be null!")
    @Size(min = 2,max = 20,message = "Size Error")
    private String firstName;

    @NotNull(message = "Last Name cannot be null!")
    @Size(min = 2,max = 20,message = "Size Error")
    private String lastName;

    private String userName;

    private String password;

    private String mail;


    private String registrationDate= new LocalDateNow().now();

}

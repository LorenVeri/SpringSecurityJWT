package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppUserDto {
    private Long ID;

    private String Username;

    private String Password;

    private String FirstName;

    private int Age;

    private String Genre;

    private String LastName;

    private String Address;

    private String Email;

    private int NumberPhone;

    private Date Birthday;
}

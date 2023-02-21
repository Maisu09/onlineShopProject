package com.sda.OnlineShop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegistrationDto {
    private String fullName;
    private String emailAddress;
    private String password;
    private String address;
    private String confirmPassword;
    private String phoneNumber;
    private String userRole;
}

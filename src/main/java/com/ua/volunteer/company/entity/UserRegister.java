package com.ua.volunteer.company.entity;

import com.ua.volunteer.company.constant.Sex;
import lombok.Data;
@Data
public class UserRegister {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String sexName;
}

package com.ua.volunteer.company.entity;

import lombok.Data;

@Data
public class PhotoUser {
    private Integer id;
    private byte[] photo;
    private Integer userId;
}

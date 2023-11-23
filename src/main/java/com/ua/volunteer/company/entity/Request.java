package com.ua.volunteer.company.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Request {
    private String id;
    private String description;
    private LocalDate requestDate;
    private Integer userId;
}

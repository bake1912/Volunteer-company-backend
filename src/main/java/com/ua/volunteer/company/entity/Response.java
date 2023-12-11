package com.ua.volunteer.company.entity;


import lombok.Data;

@Data
public class Response {
    private Integer id;
    private String responseText;
    private Integer requestId;
    private String statusName;
}

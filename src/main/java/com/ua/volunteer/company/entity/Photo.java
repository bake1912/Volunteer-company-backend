package com.ua.volunteer.company.entity;

import lombok.Data;

@Data
public class Photo {
  private Integer id;
  private byte[] photo;
  private Integer itemId;
}

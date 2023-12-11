package com.ua.volunteer.company.entity;

import lombok.Data;

@Data
public class PhotoItem {
  private Integer id;
  private byte[] photo;
  private Integer itemId;
}

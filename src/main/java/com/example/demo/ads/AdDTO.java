package com.example.demo.ads;

import lombok.Data;

@Data
public class AdDTO {
    private Long id;
    private String carName;
    private Integer price;
    private String year;
    private String description;
}

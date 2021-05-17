package com.example.demo.ads;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "car_name", nullable = false)
    private String carName;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name = "description", nullable = false)
    private String description;
}

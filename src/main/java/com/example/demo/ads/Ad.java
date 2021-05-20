package com.example.demo.ads;

import com.example.demo.common.BasicEntity;
import com.example.demo.classification.Classification;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ads")
@EqualsAndHashCode(callSuper = true)
public class Ad extends BasicEntity {

    @Column(name = "car_name", nullable = false)
    private String carName;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classification_id")
    private Classification classification;
}

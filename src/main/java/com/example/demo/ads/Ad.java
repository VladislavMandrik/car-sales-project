package com.example.demo.ads;

import com.example.demo.common.BasicEntity;
import com.example.demo.classification.Classification;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "ads")
@EqualsAndHashCode(callSuper = true)
public class Ad extends BasicEntity {

    @NotBlank(message = "Car name is mandatory")
    private String carName;
    @Column(name = "price", nullable = false)
    private Integer price;
    @NotBlank(message = "Year is mandatory")
    private String year;
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classification_id")
    private Classification classification;
}

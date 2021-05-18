package com.example.demo.classification;

import com.example.demo.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "classification")
@EqualsAndHashCode(callSuper = true)
public class Classification extends BasicEntity {

    @Column(name = "appoitment", nullable = false)
    private String appoitment;
}

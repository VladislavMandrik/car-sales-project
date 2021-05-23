package com.example.demo.classification;

import com.example.demo.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "classifications")
@EqualsAndHashCode(callSuper = true)
public class Classification extends BasicEntity {

    @Column(name = "appoitment", nullable = false)
    @NotBlank(message = "Appoitment is mandatory")
    private String appoitment;
}

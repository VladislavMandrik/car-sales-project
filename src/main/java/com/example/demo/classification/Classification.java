package com.example.demo.classification;

import com.example.demo.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "classifications")
@SQLDelete(sql = "UPDATE classifications SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@EqualsAndHashCode(callSuper = true)
public class Classification extends BasicEntity {

    @Column(name = "appointment", nullable = false)
    @NotBlank(message = "Appointment is mandatory")
    private String appointment;
}

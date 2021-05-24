package com.example.demo.common;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private boolean deleted = Boolean.FALSE;
}

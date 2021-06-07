package com.example.demo.classification;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassificationMapper {
    ClassificationDTO toClassificationDTO(Classification classification);

    Classification toClassification(ClassificationDTO classificationDTO);
}

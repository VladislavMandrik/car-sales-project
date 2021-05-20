package com.example.demo.classification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClassificationsService {

    Page<Classification> findAllClassification(Pageable pageable);

    Classification findClassificationById(Long id);

    Classification save(Classification classification);

    Classification update(Long id, Classification classification);

    void delete(Long id);
}


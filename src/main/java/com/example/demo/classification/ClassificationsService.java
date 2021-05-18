package com.example.demo.classification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClassificationsService {

    void delete(Long id);

    Classification update(Long id, Classification classification);

    Classification save(Classification classification);

    Page<Classification> findAllClassification(Pageable pageable);

    Classification findClassificationById(Long id);

}


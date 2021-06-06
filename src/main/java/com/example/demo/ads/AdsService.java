package com.example.demo.ads;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdsService {

    Page<Ad> findAll(Long classificationId, String carName, Integer price, Pageable pageable);

    Ad findAdByIdAndClassificationId(Long id, Long classificationId);

    Ad save(Long ClassificationId, Ad ad);

    Ad update(Long ClassificationId, Long id, Ad ad);

    void delete(Long ClassificationId, Long id);
}

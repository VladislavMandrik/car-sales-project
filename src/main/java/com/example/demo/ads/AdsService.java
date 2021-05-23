package com.example.demo.ads;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdsService {

    Page<Ad> findAllAdsByClassification(Long classificationId, Pageable pageable);

    Ad findAdByIdByClassification(Long id, Long classificationId);

//    Ad findAdByPriceByClassification(Integer price, Long classificationId);

    Ad save(Long ClassificationId, Ad ad);

    Ad update(Long ClassificationId, Long id, Ad ad);

    void delete(Long ClassificationId, Long id);
}

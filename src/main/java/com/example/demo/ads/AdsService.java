package com.example.demo.ads;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdsService {

    Page<Ad> findAllAdsByClassification(Long classificationId, Pageable pageable);

    Ad findAdByIdAndClassificationId(Long id, Long classificationId);

    List<Ad> findAdByClassificationIdAndPriceBetween(Long classificationId, Integer lowerPrice,
                                                     Integer higherPrice);

    List<Ad> findAdByClassificationIdAndYearIn(Long classificationId, List<String> year);

    Ad save(Long ClassificationId, Ad ad);

    Ad update(Long ClassificationId, Long id, Ad ad);

    void delete(Long ClassificationId, Long id);
}

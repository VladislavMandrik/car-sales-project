package com.example.demo.ads;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdsService {

    void delete(Long id);

    Ad update(Long id, Ad ad);

    Ad save(Ad ad);

    Page<Ad> findAllAd(Pageable pageable);

    Ad findAdById(Long id);

    Ad findAdByPrice(Integer price);

}

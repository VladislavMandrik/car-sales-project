package com.example.demo.ads;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdsRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findAllByClassificationId(Long classificationId, Pageable pageable);

    Optional<Ad> findByIdAndClassificationId(Long id, Long classificationId);

    List<Ad> findByClassificationIdAndPriceBetween(Long classificationId, Integer lowerPrice, Integer higherPrice);

    List<Ad> findByClassificationIdAndYearIn(Long classificationId, List<String> year);
}
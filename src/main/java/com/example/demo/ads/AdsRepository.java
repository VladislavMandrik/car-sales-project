package com.example.demo.ads;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdsRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findAllByClassificationId(Long classificationId, Pageable pageable);

    Optional<Ad> findByIdAndClassificationId(Long id, Long classificationId);

//    Optional<Ad> findByCarNameAndClassificationId(String carName, Long classificationId);
}
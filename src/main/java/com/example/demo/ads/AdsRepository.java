package com.example.demo.ads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdsRepository extends JpaRepository<Ad, Long> {

    Optional<Ad> findByPrice(Integer price);
}
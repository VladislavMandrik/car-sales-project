package com.example.demo.classification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationsRepository extends JpaRepository<Classification, Long> {

    Page<Classification> findAllByAppointment(String appointment, Pageable pageable);
}


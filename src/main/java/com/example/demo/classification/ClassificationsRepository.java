package com.example.demo.classification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationsRepository extends JpaRepository<Classification, Long> {

}

package com.EmlakBurada.repository;

import com.EmlakBurada.model.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolleeRepository extends JpaRepository<Enrollee,Integer> {

    Enrollee findById(int id);
}

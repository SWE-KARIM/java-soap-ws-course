package com.clinical.rest.repo;

import com.clinical.rest.model.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalRepo extends JpaRepository<ClinicalData,Integer> {
}

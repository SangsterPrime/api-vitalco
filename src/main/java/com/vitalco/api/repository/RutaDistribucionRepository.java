package com.vitalco.api.repository;

import com.vitalco.api.model.RutaDistribucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaDistribucionRepository extends JpaRepository<RutaDistribucion, Long> {
}

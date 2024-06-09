package com.carla.api.repositories;

import com.carla.api.entities.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompensationRepository
                extends JpaRepository<Compensation, Long>, JpaSpecificationExecutor<Compensation> {

}

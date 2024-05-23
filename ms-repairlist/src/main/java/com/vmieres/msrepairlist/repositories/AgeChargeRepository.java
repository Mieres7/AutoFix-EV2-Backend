package com.vmieres.msrepairlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msrepairlist.entities.AgeChargeEntity;

@Repository
public interface AgeChargeRepository extends JpaRepository<AgeChargeEntity, Long>{
    
}


package com.vmieres.msrepairlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msrepairlist.entities.KilometerChargeEntity;

@Repository
public interface KilometerChargeRepository extends JpaRepository<KilometerChargeEntity, Long>{
    
}

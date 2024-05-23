package com.vmieres.msrepairlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msrepairlist.entities.RepairDiscountEntity;

@Repository
public interface RepairDiscountRepository extends JpaRepository<RepairDiscountEntity, Long>{
    
}

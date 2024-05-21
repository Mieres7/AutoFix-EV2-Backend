package com.vmieres.msrepairlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msrepairlist.entities.RepairTypeCostEntity;

@Repository
public interface RepairTypeCostRepository extends JpaRepository<RepairTypeCostEntity, Long>{
    
}

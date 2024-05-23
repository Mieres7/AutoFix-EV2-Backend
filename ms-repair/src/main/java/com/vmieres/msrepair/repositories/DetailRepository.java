package com.vmieres.msrepair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msrepair.entities.DetailEntity;

@Repository
public interface DetailRepository extends JpaRepository<DetailEntity, Long>{
    
    public List<DetailEntity> findAllByRepairId(Long repairId);

}

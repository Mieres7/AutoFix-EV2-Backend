package com.vmieres.msrepair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msrepair.entities.RepairEntity;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long>{
    
    public boolean existsByRegistration(String registration);

    public RepairEntity findByRegistration(String registration);

}

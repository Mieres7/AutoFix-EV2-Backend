package com.vmieres.msvehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmieres.msvehicle.entities.VehicleEntity;




@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String>{
    public boolean existsByRegistration(String registration);

    public VehicleEntity findByRegistration(String registration);
}
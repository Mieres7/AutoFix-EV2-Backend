package com.vmieres.msvehicle.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msvehicle.entities.VehicleEntity;
import com.vmieres.msvehicle.repositories.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public VehicleEntity saveVehicle(VehicleEntity vehicle) throws Exception {

        if (vehicle.getRepairs() != 0) vehicle.setRepairs(0);

        String registration = vehicle.getRegistration();
        String expression = "^[A-Z]{4}\\d{2}$";
        if(registration.matches(expression)){
            if(!vehicleRepository.existsByRegistration(registration))
                return vehicleRepository.save(vehicle);
            else throw new Exception("Vehicle already exists");
        }else throw new Exception("Invalid registration format");
    }
}
package com.vmieres.msvehicle.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msvehicle.entities.VehicleEntity;
import com.vmieres.msvehicle.repositories.BrandRepository;
import com.vmieres.msvehicle.repositories.VehicleRepository;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    BrandRepository brandRepository;

    public VehicleEntity saveVehicle(VehicleEntity vehicle) throws Exception {

        if (vehicle.getRepairs() != 0) vehicle.setRepairs(0);
        System.out.println("HOOLAAAAAAAAAAAAAAAAAAA");
        System.out.println(vehicle.getBrand_id());
        String registration = vehicle.getRegistration();
        String expression = "^[A-Z]{4}\\d{2}$";
        if(registration.matches(expression)){
            if(!vehicleRepository.existsByRegistration(registration))
                return vehicleRepository.save(vehicle);
            else throw new Exception("Vehicle already exists");
        }else throw new Exception("Invalid registration format");
    }

    public VehicleEntity getVehicle(String registration){
        VehicleEntity vehicle = vehicleRepository.findByRegistration(registration);
        return vehicle;
    }

    public List<VehicleEntity> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    

}
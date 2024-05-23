package com.vmieres.msrepairlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepairlist.entities.AgeChargeEntity;
import com.vmieres.msrepairlist.repositories.AgeChargeRepository;

@Service
public class AgeChargeService {


    @Autowired
    AgeChargeRepository ageChargeRepository;

    @Autowired
    AuxService auxService;

    public float getCharge(String manufactureYear, String vehicleType){

        int age = 2024 - Integer.parseInt(manufactureYear);
        Long index = (long) auxService.getIndex3(age);
        AgeChargeEntity ageCharge = ageChargeRepository.findById(index).get();

        switch (vehicleType) {
            case "SEDAN":
                return ageCharge.getSedanCharge();
            case "HACTBACK":
                return ageCharge.getHatchbackCharge();
            case "PICKUP":
                return ageCharge.getPickupCharge();
            case "SUV":
                return ageCharge.getPickupCharge();
            case "VAN":
                return ageCharge.getVanCharge();
        }
        return 0f;



    }


}

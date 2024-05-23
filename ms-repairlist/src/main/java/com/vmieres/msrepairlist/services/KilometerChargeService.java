package com.vmieres.msrepairlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepairlist.entities.KilometerChargeEntity;
import com.vmieres.msrepairlist.repositories.KilometerChargeRepository;

@Service
public class KilometerChargeService {

    @Autowired
    KilometerChargeRepository kilometerChargeRepository;

    @Autowired
    AuxService auxService;

    public float getCharge(int km, String vehicleType){

        Long index = (long) auxService.getIndex2(km);
        KilometerChargeEntity kilometerCharge = kilometerChargeRepository.findById(index).get();

        switch (vehicleType) {
            case "SEDAN":
                return kilometerCharge.getSedanCharge();
            case "HACTBACK":
                return kilometerCharge.getHatchbackCharge();
            case "PICKUP":
                return kilometerCharge.getPickupCharge();
            case "SUV":
                return kilometerCharge.getPickupCharge();
            case "VAN":
                return kilometerCharge.getVanCharge();
        }
        return 0f;

    }   
    
}

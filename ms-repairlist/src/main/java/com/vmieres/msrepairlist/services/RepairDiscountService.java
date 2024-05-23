package com.vmieres.msrepairlist.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepairlist.entities.RepairDiscountEntity;
import com.vmieres.msrepairlist.repositories.RepairDiscountRepository;

@Service
public class RepairDiscountService {

    @Autowired
    RepairDiscountRepository repairDiscountRepository;

    @Autowired 
    AuxService auxService;

    public float getDiscount(int repairs_, String motorType){

        Long index = (long) auxService.getIndex(repairs_);
        RepairDiscountEntity repairDiscount = repairDiscountRepository.findById(index).get();

        switch (motorType) {
            case "GASOLINE":
                return repairDiscount.getGasolineCost();
            case "DIESEL":
                return repairDiscount.getDieselCost();
            case "HYBRID":
                return repairDiscount.getHybridCost();
            case "ELECTRIC":
                return repairDiscount.getElectricCost();
        }
        return 0f;
    }
    
}

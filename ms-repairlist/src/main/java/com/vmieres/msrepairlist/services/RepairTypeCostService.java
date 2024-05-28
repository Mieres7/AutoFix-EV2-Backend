package com.vmieres.msrepairlist.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepairlist.entities.RepairTypeCostEntity;
import com.vmieres.msrepairlist.repositories.RepairTypeCostRepository;

@Service
public class RepairTypeCostService {
    
    @Autowired
    RepairTypeCostRepository repairTypeCostRepository;

    public List<RepairTypeCostEntity> registerRepairTypeCost(List<RepairTypeCostEntity> repairs){

        List<RepairTypeCostEntity> savedRepairs = new ArrayList<>();

        for (RepairTypeCostEntity repair : repairs) {
            
            RepairTypeCostEntity r = new RepairTypeCostEntity();
            r.setRepairType(repair.getRepairType());
            r.setDescription(repair.getDescription());
            r.setGasolineCost(repair.getGasolineCost());
            r.setDieselCost(repair.getDieselCost());
            r.setHybridCost(repair.getHybridCost());
            r.setElectricCost(repair.getElectricCost());
            repairTypeCostRepository.save(r);
            savedRepairs.add(r);
        }
        return savedRepairs;
    }

    public List<String> getAllNames(){
        List<RepairTypeCostEntity> repairTypes = repairTypeCostRepository.findAll();
        List<String> repairName = new ArrayList<>();

        for(RepairTypeCostEntity repair : repairTypes){
            repairName.add(repair.getRepairType());
        }

        return repairName;
    }

    public int getTypeCostValue(String repairName, String motorType){
        
        RepairTypeCostEntity repairTypeCost = repairTypeCostRepository.findByRepairType(repairName);
        
        int typeCostValue = 0;

        switch (motorType) {
            case "DIESEL":
                typeCostValue = repairTypeCost.getDieselCost();
                break;
            case "GASOLINE":
                typeCostValue=  repairTypeCost.getGasolineCost();
                break;
            case "ELECTRIC":
                typeCostValue = repairTypeCost.getElectricCost();
                break;
            case "HYBRID":
                typeCostValue = repairTypeCost.getHybridCost();
                break;
        }
        
        return typeCostValue;
    }

}

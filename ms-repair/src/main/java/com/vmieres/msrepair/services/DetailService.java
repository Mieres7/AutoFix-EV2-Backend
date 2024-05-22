package com.vmieres.msrepair.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepair.entities.DetailEntity;
import com.vmieres.msrepair.entities.RepairEntity;
import com.vmieres.msrepair.repositories.DetailRepository;

@Service
public class DetailService {
    @Autowired
    DetailRepository detailRepository;

    // este metodo toma una lista de nombres de reparaciones (String) y crea un detalle por c/u. 
    // luego se las asignar a una reparacion en particular 
    public void createDetails(List<String> repairs, RepairEntity repair){

        for(String repairType: repairs){
            DetailEntity detail = new DetailEntity();
            LocalDateTime date = LocalDateTime.now();

            // aqui se tiene que calcular el costo de la reparacion
            int cost = 10000;

            detail.setRepairType(repairType);
            detail.setDate(date);
            detail.setRepairId(repair.getRepairId());

            detail.setCost(cost); // modificar!

            detail = detailRepository.save(detail);
            detail.setRepairId(repair.getRepairId());
        }
    }

}

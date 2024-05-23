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

            detail.setRepairType(repairType);
            detail.setDate(date);
            detail.setRepairId(repair.getRepairId());
            detail.setCheckOut(false);
            detail = detailRepository.save(detail);
        }
    }

    

    // funcion para actualizar valores cuando el cliente lo retira del local

}

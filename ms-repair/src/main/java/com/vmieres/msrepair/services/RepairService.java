package com.vmieres.msrepair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.vmieres.msrepair.dto.RepairDto;
import com.vmieres.msrepair.entities.DetailEntity;
import com.vmieres.msrepair.entities.RepairEntity;
import com.vmieres.msrepair.repositories.DetailRepository;
import com.vmieres.msrepair.repositories.RepairRepository;

@Service
public class RepairService {
    @Autowired
    RepairRepository repairRepository;

    @Autowired
    DetailService detailService;

    public RepairEntity registerRepairs(RepairDto data){

        if(repairRepository.existsByRegistration(data.getRegistration())){
            RepairEntity repair = repairRepository.findByRegistration(data.getRegistration());
            
            // Actualizacion de valores
            

            // creacion de details
                // para la creacion de details necestio costos
            detailService.createDetails(data.getRepairs(), repair);
 
        }else{

            // new repair

            // creacion de details

        }
        
    }


}

/*
 * Registrar reparaciones realizadas a los vehiculos:
 * Desde el front deberia llegar un json que tenga lo sgte 
 *  {
 *      - listado con el nombre de las reparaciones (estas siempre coinciden con las existentes pues los nombre se sacan del ms-repairlist)
 *      - registration del vehiculo al que se le agregan
 *      - boolean con el bonus.
 *  }
 *  
 *  Primero se tiene que determinar si ya hay registro de una reparcion con esa registration
 *      if true: se actualizan todos lo montos necesarios
 *               se crea un nuevo detail por cada reparcion que entra
 * 
 *      else:    se crea una nueva reparcion y se setea todo en 0
 *               se crea un detail por cada reparacion que entra
 *  
 */
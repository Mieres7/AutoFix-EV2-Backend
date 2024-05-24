package com.vmieres.msrepair.controllers;

import org.apache.hc.core5.http.protocol.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msrepair.dto.RepairDto;
import com.vmieres.msrepair.dto.VehicleDto;
import com.vmieres.msrepair.entities.RepairEntity;
import com.vmieres.msrepair.services.RepairService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/repair")
public class RepairController {
    
    @Autowired
    RepairService repairService;

    @PostMapping("/register")
    public ResponseEntity<RepairEntity> regiserRepair(@RequestBody RepairDto data){
        RepairEntity repair = repairService.registerRepairs(data);
        return ResponseEntity.ok(repair);
    }

    @PutMapping("/checkout-workshop/{repairId}")
    public ResponseEntity<RepairEntity> checkOutWorkshop(@PathVariable Long repairId){
        RepairEntity repair = repairService.checkOutWorkshop(repairId);
        return ResponseEntity.ok(repair);
    }

    @GetMapping("/get-total-cost/{repairId}")
    public ResponseEntity<RepairEntity> getRepairCost(@PathVariable Long repairId) {
        RepairEntity repair = repairService.getRepairCost(repairId);
        return ResponseEntity.ok(repair);
    }
    
    @GetMapping("/get")
    public ResponseEntity<Integer> get(@RequestParam("registration") Long registration){
        int v = repairService.gVehicleDto(registration);
        return ResponseEntity.ok(v);
    }

}

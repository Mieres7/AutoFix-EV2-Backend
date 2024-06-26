package com.vmieres.msrepair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msrepair.dto.RepairDto;
import com.vmieres.msrepair.entities.RepairEntity;
import com.vmieres.msrepair.services.RepairService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {
    
    @Autowired
    RepairService repairService;

    @GetMapping("/get-all")
    public ResponseEntity<List<RepairEntity>> getAll(){
        List<RepairEntity> repairs = repairService.getAll();
        return ResponseEntity.ok(repairs);
    }

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


}

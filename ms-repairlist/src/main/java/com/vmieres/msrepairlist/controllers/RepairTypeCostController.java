package com.vmieres.msrepairlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.vmieres.msrepairlist.entities.RepairTypeCostEntity;
import com.vmieres.msrepairlist.services.RepairTypeCostService;

@RestController
@RequestMapping("/repair-list")
@CrossOrigin("*")
public class RepairTypeCostController {
    
    @Autowired
    RepairTypeCostService repairTypeCostService;

    @PostMapping("/save-repairs")
    public ResponseEntity<List<RepairTypeCostEntity>> registerRepairTypeCosts(@RequestBody List<RepairTypeCostEntity> repairs){
        List<RepairTypeCostEntity> repairList = repairTypeCostService.registerRepairTypeCost(repairs);
        return ResponseEntity.ok(repairList);
    }

    @GetMapping("/get-all-names")
    public ResponseEntity<List<String>> getAllNames(){
        List<String> repairNames = repairTypeCostService.getAllNames();
        return ResponseEntity.ok(repairNames);
    }

    @GetMapping("/get-type-cost")
    public ResponseEntity<Integer> getTypeCostValue(@RequestParam String repairName, @RequestParam String vehicleType){
        int typeCostValue = repairTypeCostService.getTypeCostValue(repairName, vehicleType);
        return ResponseEntity.ok(typeCostValue);
    }

}

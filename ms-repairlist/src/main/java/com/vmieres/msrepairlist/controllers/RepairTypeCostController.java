package com.vmieres.msrepairlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class RepairTypeCostController {
    
    @Autowired
    RepairTypeCostService repairTypeCostService;

    @PostMapping("/save-repairs")
    public ResponseEntity<RepairTypeCostEntity> registerRepairTypeCosts(@RequestBody RepairTypeCostEntity repairs){
        RepairTypeCostEntity repairList = repairTypeCostService.registerRepairTypeCost(repairs);
        return ResponseEntity.ok(repairList);
    }

    @GetMapping("/get-all-names")
    public ResponseEntity<List<String>> getAllNames(){
        List<String> repairNames = repairTypeCostService.getAllNames();
        return ResponseEntity.ok(repairNames);
    }

    @GetMapping("/get-type-cost")
    public ResponseEntity<Integer> getTypeCostValue(@RequestParam String repairName, @RequestParam String motorType){
        int typeCostValue = repairTypeCostService.getTypeCostValue(repairName, motorType);
        return ResponseEntity.ok(typeCostValue);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RepairTypeCostEntity>> getAll(){
        List<RepairTypeCostEntity> rl = repairTypeCostService.getAll();
        return ResponseEntity.ok(rl);
    }

}

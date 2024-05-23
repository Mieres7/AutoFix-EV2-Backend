package com.vmieres.msrepairlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msrepairlist.services.AgeChargeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/age-charge")
public class AgeChargeController {

    @Autowired
    AgeChargeService ageChargeService;

    @GetMapping("/get-charge")
    public ResponseEntity<Float> getCharg(@RequestParam String manufactureYear, @RequestParam String vehicleType) {
        float charge = ageChargeService.getCharge(manufactureYear, vehicleType);
        return ResponseEntity.ok(charge);
    }
    

}

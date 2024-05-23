package com.vmieres.msrepairlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msrepairlist.services.KilometerChargeService;

@RestController
@RequestMapping("/km-charge")
public class KilometerChargeController {

    @Autowired
    KilometerChargeService kilometerChargeService;

    @GetMapping("/get-charge")
    public ResponseEntity<Float> getCharg(@RequestParam int km, @RequestParam String vehicleType) {
        float charge = kilometerChargeService.getCharge(km, vehicleType);
        return ResponseEntity.ok(charge);
    }
    
}

package com.vmieres.msvehicle.controlllers;

import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msvehicle.entities.VehicleEntity;
import com.vmieres.msvehicle.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/vehicle")
// @CrossOrigin("*")
public class VehicleController {
    @Autowired 
    VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<VehicleEntity> saveVehicle(@RequestBody VehicleEntity vehicle) throws Exception {
        VehicleEntity newVehicle = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(newVehicle);
    }

    @GetMapping("/get-vehicle")
    public ResponseEntity<VehicleEntity> getVehicleType(@RequestParam("registration") String registration){
        VehicleEntity vehicle = vehicleService.getVehicle(registration);
        return ResponseEntity.ok(vehicle);
    }

}
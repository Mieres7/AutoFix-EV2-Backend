package com.vmieres.msrepair.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vmieres.msrepair.dto.VehicleDto;


@FeignClient(value = "ms-vehicle")
public interface VehicleFeingClient {
    
    @GetMapping("/vehicle/get-vehicle")
    VehicleDto getVehicle(@RequestParam("registration") String registration);

    @GetMapping("/brand/get-bonus")
    int getBonus(@RequestParam("brandId") Long brandId);


}

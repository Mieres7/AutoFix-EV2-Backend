package com.vmieres.msrepair.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vmieres.msrepair.dto.VehicleDto;


@FeignClient(value = "ms-vehicle")
public interface VehicleFeingClient {
    
    @GetMapping("/vehicle/get-vehicle")
    public VehicleDto getVehicle(String registration);

}

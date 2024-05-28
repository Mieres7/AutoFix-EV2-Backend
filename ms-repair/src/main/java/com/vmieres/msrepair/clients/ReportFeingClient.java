package com.vmieres.msrepair.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vmieres.msrepair.dto.RepairUpdateReportDto;
import com.vmieres.msrepair.dto.VehicleDto;


@FeignClient(value = "ms-report")
public interface ReportFeingClient {
    
    @GetMapping("/vehicle/get-vehicle")
    VehicleDto getVehicle(@RequestParam("registration") String registration);

    @GetMapping("/brand/get-bonus")
    int getBonus(@RequestParam("brandId") Long brandId);

    @PutMapping("/report/update-report")
    void repairUpdateReport(@RequestBody RepairUpdateReportDto report);

}

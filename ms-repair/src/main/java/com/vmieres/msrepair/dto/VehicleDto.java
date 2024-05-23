package com.vmieres.msrepair.dto;

import lombok.Data;

@Data
public class VehicleDto {

    private String registration;

    private String model;
    private String vehicleType;
    private String manufactureYear;
    private String motorType;
    private int seats;
    private int mileage;
    private int repairs;
    private Long brand_id;
    
}

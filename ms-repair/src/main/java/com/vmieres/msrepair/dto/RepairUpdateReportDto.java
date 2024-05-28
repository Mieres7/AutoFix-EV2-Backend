package com.vmieres.msrepair.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairUpdateReportDto {
    private String repairTypeName;
    private String month;
    private String year;
    private String vehicleType; 
    private Integer amount;
}

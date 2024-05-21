package com.vmieres.msreport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportDataDto {
    private String month;
    private Integer vehiclesQuantity;
    private float vehiclesQPercentage;
    private Integer cost;
    private float costPercentage;


} // This class represents a month on second report.

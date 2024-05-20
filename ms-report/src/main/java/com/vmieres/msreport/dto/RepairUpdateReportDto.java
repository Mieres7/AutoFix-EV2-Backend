package com.vmieres.msreport.dto;

import java.time.YearMonth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairUpdateReportDto {

    private String repairTypeName;
    private YearMonth date;
    private String vehicleType; 
    private Integer amount;

    
}

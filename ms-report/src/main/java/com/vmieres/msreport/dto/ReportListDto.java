package com.vmieres.msreport.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReportListDto {
    private String repairTypeName;
    private List<ReportDataDto> data;

}

package com.vmieres.msreport.services;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vmieres.msreport.dto.ReportDataDto;
import com.vmieres.msreport.entities.ReportEntity;

@Service
public class DateService {

    public List<String> getPreviousThreeMonths(String month, String year) {
        YearMonth target = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));
        List<String> previousMonths = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            YearMonth previousMonth = target.minusMonths(i);
            previousMonths.add(String.format("%02d", previousMonth.getMonthValue())); // Agrega el mes en formato "MM"
            previousMonths.add(String.valueOf(previousMonth.getYear())); // Agrega el año en formato "YYYY"
        }

        return previousMonths;
    }

    // this method recieves 2 reports and compares them, funtion made for report two.
    public ReportDataDto createReportData(ReportEntity report, ReportEntity report2) {

        int totalRepairs = report.getHatchback() + report.getPickup() + report.getSedan() + report.getVan() + report.getSuv();
        int totalRepairs2 = report2.getHatchback() + report2.getPickup() + report2.getSedan() + report2.getVan() + report2.getSuv();
    
        float repairVar = ((float)(totalRepairs2 - totalRepairs) / totalRepairs) * 100;
    
        int totalAmount = report.getHatchbackAmount() + report.getPickupAmount() + report.getSedanAmount() + report.getSuvAmount() + report.getVanAmount();
        int totalAmount2 = report2.getHatchbackAmount() + report2.getPickupAmount() + report2.getSedanAmount() + report2.getSuvAmount() + report2.getVanAmount();
    

        float amountVar = ((float)(totalAmount2 - totalAmount) / totalAmount) * 100;
    
        ReportDataDto data = new ReportDataDto(report2.getMonth(), totalRepairs2, repairVar, totalAmount2, amountVar);
        return data;
    }
}

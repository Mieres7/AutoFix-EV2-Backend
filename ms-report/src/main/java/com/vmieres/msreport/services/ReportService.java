package com.vmieres.msreport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import com.vmieres.msreport.clients.RepairListFeingClient;
import com.vmieres.msreport.dto.RepairUpdateReportDto;
import com.vmieres.msreport.entities.ReportEntity;
import com.vmieres.msreport.repositories.ReportRepository;

@Service
public class ReportService {

    RepairListFeingClient feingClient;
    
    @Autowired
    ReportRepository reportRepository;

    public ReportEntity saveReport(ReportEntity report) throws Exception{
        return reportRepository.save(report);
    }

    // method that update a report with data from repair ms y the report doesnt exists, ir generate an empty 
    // report for evert repair type that exist for an especific year and month.
    public ReportEntity repairUpdateReport(RepairUpdateReportDto reportData){


        // if(!reportRepository.existsByDate(reportData.getDate()))
        //     this.generateEmptyReports(reportData.getDate()); //generates the empty reports.
        
        ReportEntity report = reportRepository.findByRepairTypeNameAndPeriod(reportData.getRepairTypeName(), reportData.getDate());

        switch (reportData.getVehicleType()) {
            case "SEDAN":
                report.setSedan(report.getSedan() + 1);
                report.setSedanAmount(report.getSedanAmount() + reportData.getAmount());
                break;
            case "HATCHBACK":
                report.setHatchback(report.getHatchback() + 1);
                report.setHatchbackAmount(report.getHatchbackAmount() + reportData.getAmount());
                break;
            case "PICKUP":
                report.setPickup(report.getPickup() + 1);
                report.setPickupAmount(report.getPickupAmount() + reportData.getAmount());
                break;
            case "SUV":
                report.setSuv(report.getSuv() + 1);
                report.setSuvAmount(report.getSuvAmount() + reportData.getAmount());
                break;
            case "VAN":
                report.setVan(report.getVan() + 1);
                report.setVanAmount(report.getVanAmount() + reportData.getAmount());
                break;
            default:
                break;
        }
        return reportRepository.save(report);
    }

    public void generateEmptyReports(YearMonth period){

        List<String> repairNames = feingClient.getRepairTypeNames(); 

        for (String name : repairNames) {
            ReportEntity report = new ReportEntity();
            report.setRepairTypeName(name);
            report.setPeriod(period);
            report.setSedan(0);
            report.setSedanAmount(0);
            report.setHatchback(0);
            report.setHatchbackAmount(0);
            report.setPickup(0);
            report.setPickupAmount(0);
            report.setSuv(0);
            report.setSuvAmount(0);
            report.setVan(0);
            report.setVanAmount(0);
            reportRepository.save(report);
        }
    }

    // this method corresponde to report 1 function.
    public ArrayList<ReportEntity> getReports(YearMonth period){
        return (ArrayList<ReportEntity>) reportRepository.findAllByPeriod(period);
    }




}

package com.vmieres.msreport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.vmieres.msreport.clients.RepairListFeingClient;
import com.vmieres.msreport.dto.RepairUpdateReportDto;
import com.vmieres.msreport.dto.ReportDataDto;
import com.vmieres.msreport.dto.ReportListDto;
import com.vmieres.msreport.entities.ReportEntity;
import com.vmieres.msreport.repositories.ReportRepository;

@Service
public class ReportService {

    RepairListFeingClient feingClient;
    
    @Autowired
    ReportRepository reportRepository;

    @Autowired
    DateService dateService;

    public ReportEntity saveReport(ReportEntity report) throws Exception{
        return reportRepository.save(report);
    }

    // method that update a report with data from repair ms y the report doesnt exists, ir generate an empty 
    // report for evert repair type that exist for an especific year and month.
    public ReportEntity repairUpdateReport(RepairUpdateReportDto reportData){


        if(!reportRepository.existsByMonthAndYear(reportData.getMonth(), reportData.getYear()))
            this.generateEmptyReports(reportData.getMonth(), reportData.getYear()); //generates the empty reports.
        
        ReportEntity report = reportRepository.findByRepairTypeNameAndMonthAndYear(reportData.getRepairTypeName(), reportData.getMonth(), reportData.getYear());

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

    public void generateEmptyReports(String month, String year){

        List<String> repairNames = feingClient.getRepairTypeNames(); 
        // List<String> repairNames = new ArrayList<>();
        // repairNames.add("repair1");
        // repairNames.add("repair2");
        // repairNames.add("repair3");

        for (String name : repairNames) {
            ReportEntity report = new ReportEntity();
            report.setRepairTypeName(name);
            report.setMonth(month);
            report.setYear(year);
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
    public ArrayList<ReportEntity> getReports(String month, String year){
        return (ArrayList<ReportEntity>) reportRepository.findAllByMonthAndYear(month, year);
    }

    // this method corresponde to report 2 function.
    public List<ReportListDto> getReportsComparison(String month, String year){

        List<String> previousThreeMonths = dateService.getPreviousThreeMonths(month, year);

        List<ReportEntity> DateActual = reportRepository.findAllByMonthAndYear(month, year);
        List<ReportEntity> DateMinusOne = reportRepository.findAllByMonthAndYear(previousThreeMonths.get(0), previousThreeMonths.get(1));
        List<ReportEntity> DateMinusTwo = reportRepository.findAllByMonthAndYear(previousThreeMonths.get(2), previousThreeMonths.get(3));
        List<ReportEntity> DateMinusThree = reportRepository.findAllByMonthAndYear(previousThreeMonths.get(4), previousThreeMonths.get(5));

        List<ReportListDto> report = new ArrayList<>();

        for(int i = 0; i < DateActual.size(); i++){
            ReportEntity r = DateActual.get(i);
            ReportEntity r1 = DateMinusOne.get(i);
            ReportEntity r2 = DateMinusTwo.get(i);
            ReportEntity r3 = DateMinusThree.get(i);

            ReportDataDto data1 = dateService.createReportData(r, r1);
            ReportDataDto data2 = dateService.createReportData(r, r2);
            ReportDataDto data3 = dateService.createReportData(r, r3);

            List<ReportDataDto> dataList = new ArrayList<>();
            dataList.add(data1);
            dataList.add(data2);
            dataList.add(data3);

            ReportListDto list = new ReportListDto();
            list.setRepairTypeName(r.getRepairTypeName());
            list.setData(dataList);

            report.add(list);
        }

        return report;
    }



}

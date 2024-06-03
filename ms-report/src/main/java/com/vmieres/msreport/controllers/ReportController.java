package com.vmieres.msreport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msreport.dto.DateDto;
import com.vmieres.msreport.dto.RepairUpdateReportDto;
import com.vmieres.msreport.dto.ReportListDto;
import com.vmieres.msreport.entities.ReportEntity;
import com.vmieres.msreport.services.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/save")
    public ResponseEntity<ReportEntity> saveReporEntity(@RequestBody ReportEntity report) throws Exception{
        ReportEntity newReport = reportService.saveReport(report);
        return  ResponseEntity.ok(newReport);
    }
    
    @PutMapping("/update-report")
    public ResponseEntity<ReportEntity> updateReport(@RequestBody RepairUpdateReportDto data) {
        ReportEntity report = reportService.repairUpdateReport(data);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/get-all/{month}/{year}")
    public ResponseEntity<List<ReportEntity>> getReports(@PathVariable String month, @PathVariable String year) {
        List<ReportEntity> reports = reportService.getReports(month, year);
        return ResponseEntity.ok(reports);
    }
    
    @GetMapping("/get-comparison/{month}/{year}")
    public ResponseEntity<List<ReportListDto>> getReportComparison(@PathVariable String month, @PathVariable String year){
        List<ReportListDto> report = reportService.getReportsComparison(month, year);
        return ResponseEntity.ok(report);
    }

}

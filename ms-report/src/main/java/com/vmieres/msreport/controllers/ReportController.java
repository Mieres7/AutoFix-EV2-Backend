package com.vmieres.msreport.controllers;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmieres.msreport.dto.YearMonthDto;
import com.vmieres.msreport.entities.ReportEntity;
import com.vmieres.msreport.services.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/save")
    public ResponseEntity<ReportEntity> saveReporEntity(@RequestBody ReportEntity report) throws Exception{
        ReportEntity newReport = reportService.saveReport(report);
        return  ResponseEntity.ok(newReport);
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<List<ReportEntity>> getReports(@RequestBody YearMonthDto period) {
        YearMonth p = YearMonth.parse(period.getPeriod());
        List<ReportEntity> reports = reportService.getReports(p);
        return ResponseEntity.ok(reports);
    }
    

}

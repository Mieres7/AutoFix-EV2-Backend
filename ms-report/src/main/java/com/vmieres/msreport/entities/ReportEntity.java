package com.vmieres.msreport.entities;

import java.time.YearMonth;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
public class ReportEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String repairTypeName;
    private YearMonth date;
    private  List<Integer> sedan; 
    private  List<Integer> hatchback; 
    private  List<Integer> pickup; 
    private  List<Integer> suv; 
    private  List<Integer> van; 

}

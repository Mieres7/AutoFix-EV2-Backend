package com.vmieres.msreport.entities;


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
    private String month;
    private String year;
    private int sedan;  // represents how many sedan vehicles have this repair
    private int sedanAmount; // represents the total cost of sedan types repairs.
    private int hatchback; 
    private int hatchbackAmount;
    private int pickup; 
    private int pickupAmount;
    private int suv; 
    private int suvAmount;
    private int van; 
    private int vanAmount;

}

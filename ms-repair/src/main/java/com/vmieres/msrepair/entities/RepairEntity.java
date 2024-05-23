package com.vmieres.msrepair.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "repair")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Long repairId;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime clientCheckOut;

    private int repairs; // idk what name should this have, it represents the sum of the base value of all repair registered to a vehicle.
    private int charges;
    private int discount;
    private int iva;
    private int totalCostBeforeIva;
    private int totalCost;

    private boolean bonus;

    private String registration; //represents the vehicle
    
}

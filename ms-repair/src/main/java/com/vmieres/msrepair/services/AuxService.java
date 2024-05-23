package com.vmieres.msrepair.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmieres.msrepair.clients.AgeChargeClient;
import com.vmieres.msrepair.clients.KilometerChargeClient;
import com.vmieres.msrepair.clients.RepairDiscountClient;
import com.vmieres.msrepair.clients.RepairListFeingClient;
import com.vmieres.msrepair.clients.VehicleFeingClient;
import com.vmieres.msrepair.entities.DetailEntity;

@Service
public class AuxService {

    @Autowired
    RepairListFeingClient RLfeingClient;

    @Autowired
    VehicleFeingClient VfeingClient;

    @Autowired
    RepairDiscountClient RDFeingClient;

    @Autowired
    KilometerChargeClient KMCFeingClient;

    @Autowired
    AgeChargeClient ACFeingClient;

    public List<Integer> getTypeCosts(List<DetailEntity> details, String vehicleType){

        List<Integer> typeCosts = new ArrayList<>();
        for(DetailEntity detail: details){
            int c = RLfeingClient.getTypeCostValue(detail.getRepairType(), vehicleType);
            typeCosts.add(c);
        }
        return typeCosts;
    }

    public int daysBetween(LocalDateTime checkOut, LocalDateTime clientCheckOut){
        Duration duration = Duration.between(checkOut, clientCheckOut); 
        int daysBetween = (int) duration.toDays();
        return daysBetween;
    }

    public boolean isAttentionDayDiscount(LocalDateTime checkIn){
        if(checkIn.getDayOfWeek().getValue() == 1 || checkIn.getDayOfWeek().getValue() == 4){
            if(checkIn.getHour() >= 9 && checkIn.getHour() <= 12)
                return true;
        }
        return false;
    }

    public List<Integer> getTotalCost(int totalBaseCost, int repairs_, int km, String age, int bonus, boolean attentionDay, int daysBetween, String vehicleType, String motorType){
        
        // aqui tengo que pedir el % de cada tabla y luego realizar los calculos
        // seria hacer un get a 3 tablas
        // los otros son con if
        // y se retorna todo en int!

        //Discounts
        // 1. this value represents the discount by number of repairs
        float repairDiscount =  RDFeingClient.getDiscount(repairs_, motorType); 
        int finalRepairDiscount = (int)( totalBaseCost * repairDiscount);
        // 2. it gets a 10% of discount depending on the day that the repair is registered
        int fintalAttentionDiscount = (attentionDay) ? (int)(totalBaseCost * 0.1) : 0;
        // 3. 
        // bonus

        //Charges
        // 1. km charge
        float kmCharge = KMCFeingClient.getDiscount(km, vehicleType);
        int finalKmCharge = (int)(totalBaseCost * kmCharge);
        // 2. age charge
        float ageCharge = ACFeingClient.getDiscount(age, vehicleType);
        int finalAgeCharge = (int)(totalBaseCost * ageCharge);
        //  3. late charge
        int lateCharge = (int)(totalBaseCost * daysBetween * 0.05);
        
        int discounts = finalRepairDiscount + fintalAttentionDiscount + bonus;
        int charges = finalKmCharge + finalAgeCharge + lateCharge;
        int iva = (int) ((totalBaseCost + charges - discounts) * 0.19);
        int repairTotalCostBeforeIva = (totalBaseCost + charges - discounts);
        int repairTotalCost = (int) ((totalBaseCost + charges - discounts) * 1.19);

        List<Integer> totalCost = new ArrayList<>();
        totalCost.add(discounts);
        totalCost.add(charges);
        totalCost.add(iva);
        totalCost.add(repairTotalCostBeforeIva);
        totalCost.add(repairTotalCost);

        return totalCost;
        //REVISAR CUANDO SE TRIGGEREA LA FUNCION, LUEGO PROBAR QUE TODO FUNCIONE.

    }

}

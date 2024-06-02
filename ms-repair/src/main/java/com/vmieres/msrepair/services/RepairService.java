package com.vmieres.msrepair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import com.vmieres.msrepair.clients.RepairListFeingClient;
import com.vmieres.msrepair.clients.ReportFeingClient;
import com.vmieres.msrepair.clients.VehicleFeingClient;
import com.vmieres.msrepair.dto.RepairDto;
import com.vmieres.msrepair.dto.RepairUpdateReportDto;
import com.vmieres.msrepair.dto.VehicleDto;
import com.vmieres.msrepair.entities.DetailEntity;
import com.vmieres.msrepair.entities.RepairEntity;
import com.vmieres.msrepair.repositories.DetailRepository;
import com.vmieres.msrepair.repositories.RepairRepository;

@Service
public class RepairService {
    @Autowired
    RepairRepository repairRepository;

    @Autowired
    DetailService detailService;

    @Autowired
    DetailRepository detailRepository;

    @Autowired
    AuxService auxService;

    @Autowired
    RepairListFeingClient RLfeingClient;

    @Autowired
    VehicleFeingClient VfeingClient;

    @Autowired
    ReportFeingClient RfeingClient;

    
    // register of a repair with all its details and values set on 0.
    // they get calculated on the checkout time.
    public RepairEntity registerRepairs(RepairDto data){

        RepairEntity repair;
        if(repairRepository.existsByRegistration(data.getRegistration()))
            repair = repairRepository.findByRegistration(data.getRegistration());
        else
            repair = initialRepair(data.getRegistration(),data.isBonus());
        
        detailService.createDetails(data.getRepairs(), repair);
        return repair;
    }

    // this method sets a repair with its initial necesary values
    public RepairEntity initialRepair(String registration, boolean bonus){
        RepairEntity repair = new RepairEntity();
        LocalDateTime checkIn = LocalDateTime.now();

        repair.setCheckIn(checkIn);
        repair.setRegistration(registration);
        repair.setBonus(bonus);        
        return repairRepository.save(repair);
    }

    // update a repair when the car gets out of the workshop
    public RepairEntity checkOutWorkshop(Long repairId){
        RepairEntity repair = repairRepository.findById(repairId).get();
        LocalDateTime checkOutWorkshop = LocalDateTime.now();
        repair.setCheckOut(checkOutWorkshop);
        return repairRepository.save(repair);
    }

    public RepairEntity checkOutClient(Long repairId){
        return getRepairCost(repairId);
    }

    // this method calculate the cost of a repair whith all ist detail included
    // it gets triggered when clientCheckOut happends
    // the car shouldve left left the workshop
    public RepairEntity getRepairCost(Long repairId){

        RepairEntity repair = repairRepository.findById(repairId).get();
        List<DetailEntity> details = detailRepository.findAllByRepairId(repairId);
        
        VehicleDto vehicle = VfeingClient.getVehicle(repair.getRegistration());
        
        // get data from vehicle
        // type costs
        List<Integer> typeCosts = auxService.getTypeCosts(details, vehicle.getMotorType());

        //#repairs, 
        int repairs_ = vehicle.getRepairs();
        //km,   
        int km = vehicle.getMileage();
        //age,
        String age = vehicle.getManufactureYear();
        // bonus, 
        int bonus = 0;
        if(repair.isBonus()){
            // search the bonus value
            bonus = VfeingClient.getBonus(vehicle.getBrand_id());
        }
        //attention day,
        boolean attentionDayDiscount = auxService.isAttentionDayDiscount(repair.getCheckIn());
        //gets the daysBetween two dates to determinate if it has some charges
        int daysBetween = auxService.daysBetween(repair.getCheckOut(), LocalDateTime.now());

        // tengo que setear cada detail
        int totalBaseCost = 0;
        for(int i = 0; i < details.size(); i++){
            details.get(i).setCost(typeCosts.get(i)); // actualizo detail
            detailRepository.save(details.get(i)); // guardo cambios
            totalBaseCost = totalBaseCost + typeCosts.get(i);
        }

        List<Integer> totalCost = auxService.getTotalCost(totalBaseCost, repairs_, km, age, bonus, attentionDayDiscount, daysBetween, vehicle.getVehicleType(), vehicle.getMotorType());

        LocalDateTime checkOutClient = LocalDateTime.now();
        repair.setClientCheckOut(checkOutClient);

        repair.setRepairs(totalBaseCost);
        repair.setDiscount(totalCost.get(0));
        repair.setCharges(totalCost.get(1));
        repair.setIva(totalCost.get(2));
        repair.setTotalCostBeforeIva(totalCost.get(3));
        repair.setTotalCost(totalCost.get(4));

        // set/update report
        RepairUpdateReportDto report = new RepairUpdateReportDto();
        
        LocalDateTime date = repair.getCheckIn();
        int month = date.getMonthValue();
        int year = date.getYear();
        
        report.setRepairTypeName(details.get(0).getRepairType());
        String monthString = String.format("%02d", month); 
        String yearString = String.valueOf(year);
        report.setMonth(monthString);
        report.setYear(yearString);
        report.setVehicleType(vehicle.getVehicleType());
        report.setAmount(totalBaseCost);

        RfeingClient.repairUpdateReport(report); 

        return repairRepository.save(repair);
    }

    public List<RepairEntity> getAll(){
        return repairRepository.findAll();
    }


}



package com.bits.m2.assetmaster.controller;

import com.bits.m2.assetmaster.dao.entity.Vehicle;
import com.bits.m2.assetmaster.sdo.VehicleSdo;
import com.bits.m2.assetmaster.service.VehicleService;
import com.bits.m2.assetmaster.util.VehicleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleSdo>> vehicleList() {
        List<Vehicle> vehicleList = vehicleService.listOfVehicles();
        List<VehicleSdo> vehicleSdoList = VehicleConverter.convertToVehicleSdo(vehicleList);
        return new ResponseEntity<>(vehicleSdoList, HttpStatus.OK);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleSdo> vehicleById(@PathVariable("id") Long id) {
        Vehicle vehicle = vehicleService.vehicleById(id);
        VehicleSdo vehicleSdo = VehicleConverter.convertToVehicleSdo(vehicle);
        return new ResponseEntity<>(vehicleSdo, HttpStatus.OK);
    }
    @PostMapping("/vehicles")
    public VehicleSdo saveVehicle(@RequestBody VehicleSdo vehicleSdo) {
        Vehicle vehicle= vehicleService.saveVehicle(vehicleSdo);
        VehicleSdo vehicleSdo1= VehicleConverter.convertToVehicleSdo(vehicle);
        return vehicleSdo1;
    }

}

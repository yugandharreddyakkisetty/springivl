package com.bits.m2.assetmaster.service.impl;

import com.bits.m2.assetmaster.dao.TransporterRepo;
import com.bits.m2.assetmaster.dao.VehicleRepo;
import com.bits.m2.assetmaster.dao.entity.Transporter;
import com.bits.m2.assetmaster.dao.entity.Vehicle;
import com.bits.m2.assetmaster.sdo.VehicleSdo;
import com.bits.m2.assetmaster.service.VehicleService;
import com.bits.m2.common.RapidGenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private TransporterRepo transporterRepo;

    @Override
    public List<Vehicle> listOfVehicles() {
        return vehicleRepo.findAll();

    }
    @Override
    public Vehicle saveVehicle(VehicleSdo vehicleSdo) throws RapidGenericException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleSdo.getVehicleNumber());
        vehicle.setDisplayName(vehicleSdo.getDisplayName());
        if(vehicleSdo.getTransporterId() != null) {
            Optional<Transporter> transporterOptional = transporterRepo.findById(vehicleSdo.getTransporterId());
            if (!transporterOptional.isPresent()) {
                throw  new RapidGenericException("Transporter not found");
            }
            vehicle.setTransporter(transporterOptional.get());
        }
        return vehicleRepo.save(vehicle);

    }
    @Override
    public Vehicle vehicleById(Long id) throws RapidGenericException{
        Optional<Vehicle> vehicleOptional= vehicleRepo.findById(id);
        if(vehicleOptional.isPresent()) return vehicleOptional.get();
        else throw new RapidGenericException("Invalid vehicle id");
    }


}

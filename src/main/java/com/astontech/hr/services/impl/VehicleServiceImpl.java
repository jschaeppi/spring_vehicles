package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }
    
    @Override
    public Vehicle findVehicleById(Integer id) {
        return vehicleRepository.findVehicleById(id);
    }
    
    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    
    @Override
    public Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable) {
        return vehicleRepository.saveAll(vehicleIterable);
    }
    
    @Override
    public void deleteAllVehicles(Iterable<Vehicle> vehiclesList) {
        vehicleRepository.deleteAll(vehiclesList);
    }
    
    @Override
    public void deleteVehicleById(Integer id) {
        vehicleRepository.deleteById(id);
    }
    
    //Implementation of deleting vehicle details by model
    // id for referential integrity
    @Override
    public void deleteVehicleByModelId(Integer id) {
        vehicleRepository.deleteVehicleByVehicleModelId(id);
    }
}

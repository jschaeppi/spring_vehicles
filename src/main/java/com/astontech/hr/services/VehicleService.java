package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;

public interface VehicleService {
    
    
    Iterable<Vehicle> listAllVehicles();
    
    Vehicle findVehicleById(Integer id);
    
    Vehicle saveVehicle(Vehicle vehicle);
    
    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);
    
    void deleteAllVehicles(Iterable<Vehicle> vehicleList);
    
    void deleteVehicleById(Integer id);
    
    void deleteVehicleByModelId(Integer id);
}

package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

public interface VehicleMakeService {
    
    
    Iterable<VehicleMake> listAll();
    
    VehicleMake getVehicleById(Integer id);
    
    VehicleMake saveMake(VehicleMake vehicleMake);
    
    Iterable<VehicleMake> saveVehicleList(Iterable<VehicleMake>vehicleMakeIterable);
    
    void deleteVehicleMakeById(Integer id);
    
    VehicleMake findVehicleMakeByName(String makeName);
}

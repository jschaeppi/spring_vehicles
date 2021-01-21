package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService {
    
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;
    
    @Override
    public Iterable<VehicleMake> listAll() {
        return vehicleMakeRepository.findAll();
    }
    
    @Override
    public VehicleMake getVehicleById(Integer id) {
        return vehicleMakeRepository.findById(id).orElse(null);
    }
    
    @Override
    public VehicleMake findVehicleMakeByName(String makeName) {
        return vehicleMakeRepository.findVehicleMakeByVehicleMakeName(makeName);
    }
    
    @Override
    public VehicleMake saveMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }
    
    @Override
    public Iterable<VehicleMake> saveVehicleList(Iterable<VehicleMake> vehicleMakeIterable) {
        return vehicleMakeRepository.saveAll(vehicleMakeIterable);
    }
    
    @Override
    public void deleteVehicleMakeById(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}

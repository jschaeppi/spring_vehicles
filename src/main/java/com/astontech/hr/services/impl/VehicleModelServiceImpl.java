package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {
    
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    
    @Override
    public Iterable<VehicleModel> listAllModels() {
        return vehicleModelRepository.findAll();
    }
    
    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<VehicleModel> findVehicleIdByModelId(Integer id) {
        return vehicleModelRepository.findVehicleByModelId(id);
    }
    
    @Override
    public VehicleModel findModelByName(String modelName) {
        return vehicleModelRepository.findVehicleModelByVehicleModelName(modelName);
    }
    
    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }
    
    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable) {
        return vehicleModelRepository.saveAll(vehicleModelIterable);
    }
    
    @Override
    public void deleteVehicleModelById(Integer id) {
        vehicleModelRepository.deleteVehicleModelByVehicleModelId(id);
    }
    
    //Implementation of deleting model by the make Id for
    // referential integrity
    @Override
    public void deleteModelByMakeId(Integer id) {
        vehicleModelRepository.deleteModelByMakeId(id);
    }
}

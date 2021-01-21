package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

import java.util.List;

public interface VehicleModelService{
    Iterable<VehicleModel> listAllModels();
    
    VehicleModel getVehicleModelById(Integer id);
    
    List<VehicleModel> findVehicleIdByModelId(Integer id);
    
    VehicleModel findModelByName(String modelName);
    VehicleModel saveVehicleModel(VehicleModel vehicleModel);
    
    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel>vehicleModelIterable);
    
    void deleteVehicleModelById(Integer id);
    
    void deleteModelByMakeId(Integer id);
}

package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {
    
    //Delete model by it's id
    @Transactional
    @Modifying
    @Query("delete " +
            " from VehicleModel vmo" +
            " where vmo.vehicleModelId = :id")
    void deleteVehicleModelByVehicleModelId(@Param("id") Integer id);
    
    //Delete model by the make Id for referntial integrity
    @Transactional
    @Modifying
    @Query(value = "delete " +
            " from vehicle_models " +
            " where  vehicle_make_id = :id", nativeQuery = true)
    void deleteModelByMakeId(@Param("id") Integer id);
    
    //Select vehicle by the make Id
    @Query(value = "select vmo.vehicle_model_id" +
            " from vehicle_models vmo" +
            " where vehicle_make_id = :id", nativeQuery
            = true)
    List<VehicleModel> findVehicleByModelId(Integer id);
    
    VehicleModel findVehicleModelByVehicleModelName(String modelName);
}

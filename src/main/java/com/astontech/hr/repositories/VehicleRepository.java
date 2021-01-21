package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    
    //Finding all vehicles, makes and models
    @Query("SELECT v, vmo, vma" +
            " FROM Vehicle v" +
            " JOIN v.vehicleModel vmo" +
            " JOIN vmo.vehicleMake vma" +
            " WHERE v.vehicleId = :id")
    Vehicle findVehicleById(@Param("id") int Id);
    
    
    //Deleting vehicle details by the model Id for
    // referential integrity
    @Transactional
    @Modifying
    @Query(value = "delete " +
            "from vehicle_details " +
            "where vehicle_model_id = :id",
            nativeQuery = true)
    void deleteVehicleByVehicleModelId(@Param("id") Integer id);
    
}

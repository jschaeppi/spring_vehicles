package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.repository.CrudRepository;

public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {

    //Query for deleting the make by it's make name
    VehicleMake findVehicleMakeByVehicleMakeName(String makeName);
}

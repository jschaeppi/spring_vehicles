package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.VehicleMake;

public class VehicleModelVO {
    
    //region PROPERTIES
    
    private String vehicleModelName;
    
    private String vehicleMakeName;
    
    //endregion
    
    //region GETTERS / SETTERS
    
    public String getVehicleModelName() {
        return vehicleModelName;
    }
    
    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }
    
    public String getVehicleMakeName() {
        return vehicleMakeName;
    }
    
    public void setVehicleMakeName(String makeName) {
        this.vehicleMakeName = makeName;
    }
    
    //endregion
}

package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class VehicleModel {
    
    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleModelId;
    
    @Version
    private Integer version;
    private String vehicleModelName;
    
    @ManyToOne
    private VehicleMake vehicleMake;
    
    //endregion
    
    //region CONSTRUCTORS
    
    public VehicleModel() {
    }
    
    public VehicleModel(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }
    
    //endregion
    
    //region GETTERS / SETTERS
    
    public int getVehicleModelId() {
        return this.vehicleModelId;
    }
    
    public void setVehicleModelId(int vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }
    
    public String getVehicleModelName() {
        return this.vehicleModelName;
    }
    
    public void setVehicleModelName(String vehicleModelMake) {
        this.vehicleModelName= vehicleModelMake;
    }
    
/*    public List<Vehicle> getVehicleList() {
        return this.vehicleList;
    }
    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }*/
    
    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }
    
    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
    
    
    //endregion
    
    //region CUSTOM METHODS
    
    //endregion

}
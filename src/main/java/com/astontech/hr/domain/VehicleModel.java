package com.astontech.hr.domain;

import com.astontech.hr.domain.Vehicle;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="VehicleModels")
public class VehicleModel {
    
    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VehicleModelId")
    private Integer vehicleModelId;
    
    @Version
    private Integer version;
    private String vehicleModelName;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_make_id")
    private VehicleMake vehicleMake;
    
/*    @OneToMany(mappedBy = "vehicleModel")
    private Collection<Vehicle> vehicle;
    */
    //endregion
    
    //region CONSTRUCTORS
    
    public VehicleModel() {
        //this.vehicleList = new ArrayList<>();
    }
    
    public VehicleModel(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
        //this.vehicleList = new ArrayList<>();
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
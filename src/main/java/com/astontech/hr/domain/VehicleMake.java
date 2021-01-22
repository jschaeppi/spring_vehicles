package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "VehicleMakes")
public class VehicleMake {
    
    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "VehicleMakeId")
    private Integer vehicleMakeId;
    
    @Version
    private Integer version;
    private String vehicleMakeName;
    private Date createDate;
    
    //endregion
    
    //region CONSTRUCTORS
    
    public VehicleMake() {
        //this.vehicleModelList = new ArrayList<>();
        
    }
    
    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }
    
    public VehicleMake(String vehicleMakeName, Date createDate) {
        //this.vehicleModelList = new ArrayList<>();
        this.vehicleMakeName = vehicleMakeName;
        this.createDate = createDate;
    }
    
    //endregion
    
    //region GETTERS / SETTERS
    
    public int getVehicleMakeId() {
        return this.vehicleMakeId;
    }
    
    public void setVehicleMakeId(int vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }
    
    public String getVehicleMakeName() {
        return this.vehicleMakeName;
    }
    
    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
/*    public List<VehicleModel> getVehicleModelList() {
        return this.vehicleModelList;
    }
    
    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }*/
    
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    //endregion
    
    //region CUSTOM METHODS
    
    
    //endregion
}
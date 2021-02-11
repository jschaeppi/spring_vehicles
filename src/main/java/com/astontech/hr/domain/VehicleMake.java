package com.astontech.hr.domain;

import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "VehicleMakes")
public class VehicleMake {
    
    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MakeId")
    private Integer vehicleMakeId;
    
    @Version
    private Integer version;
    private String vehicleMakeName;
    private Date createDate;
    
    @OneToMany(mappedBy = "vehicleMake")
    private List<VehicleModel> vehicleModelList;
    //endregion
    
    //region CONSTRUCTORS
    
    public VehicleMake() {
        
    }
    
    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }
    
    public VehicleMake(String vehicleMakeName, Date createDate) {
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
    
    public List<VehicleModel> getVehicleModelList() {
        return this.vehicleModelList;
    }
    
    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }
    
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
package com.astontech.hr.domain.VO;

import java.util.Date;

public class VehicleMakeVO {
    
    //region PROPERTIES
    
    private Integer vehicleMakeId;
    private String vehicleMake;
    
    private Date createDate;
    
    public VehicleMakeVO() {
        this.setCreateDate(new Date());
    }
    //endregion
    
    //region GETTERS / SETTERS
    public String getVehicleMake() {
        return vehicleMake;
    }
    
    public void setVehicleMake(String vehicleMakeName) {
        this.vehicleMake = vehicleMakeName;
    }
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Integer getVehicleMakeId() {
        return vehicleMakeId;
    }
    
    public void setVehicleMakeId(Integer vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }
    
    //endregion
    
}

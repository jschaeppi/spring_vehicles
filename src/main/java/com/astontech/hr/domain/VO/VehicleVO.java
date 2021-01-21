package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.VehicleModel;

import javax.persistence.*;

public class VehicleVO {
    
    //region PROPERTIES
    
    private int year;
    private String licensePlate;
    private String vin;
    private String color;
    private boolean isPurchase;
    private double purchasePrice;
    private int purchaseDate;

    private String vehicleModel;
    
    private String vehicleMake;
    
    //endregion
    
    //region GETTERS / SETTERS
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getVin() {
        return this.vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean getIsPurchase() {
        return this.isPurchase;
    }
    
    public void setIsPurchase(boolean isPurchase) {
        this.isPurchase = isPurchase;
    }
    
    public double getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public int getPurchaseDate() {
        return this.purchaseDate;
    }
    
    public void setPurchaseDate(int purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public String getVehicleModel() {
        return vehicleModel;
    }
    
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    public String getVehicleMake() {
        return vehicleMake;
    }
    
    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
    
    //endregion
    
    //region CUSTOM METHODS
    
    
    
    //endregion
}

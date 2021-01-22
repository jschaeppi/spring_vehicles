package com.astontech.hr.domain;


import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name="VehicleDetails")
public class Vehicle {
    
    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "VehicleId")
    private Integer vehicleId;
    
    @Version
    private Integer version;
    
    private int year;
    private String licensePlate;
    private String vin;
    private String color;
    private boolean isPurchase;
    private double purchasePrice;
    private int purchaseDate;
    
    @ManyToOne
//    @JoinColumn(name = "vehicle_model_id")
    private VehicleModel vehicleModel;
    
    //endregion
    
    //region CONSTRUCTORS
    
    public Vehicle() {
    
    }
    
    public Vehicle(int year,
                   String licensePlate,
                   String vin,
                   String color,
                   boolean isPurchase,
                   int purchaseDate,
                   double purchasePrice) {
                this.year = year;
                this.licensePlate = licensePlate;
                this.vin = vin;
                this.color = color;
                this.isPurchase = isPurchase;
                this.purchaseDate = purchaseDate;
                this.purchasePrice = purchasePrice;
    }
    
    //endregion
    
    //region GETTERS / SETTERS
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public int getVehicleId() {
        return this.vehicleId;
    }
    
    public void setVehicleId(int id) {
        this.vehicleId = id;
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
    
    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }
    
    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    //endregion
    
    //region CUSTOM METHODS
    @Override
    public String toString() {
        return this.getYear() + " " + this.getColor() + " " + this.getLicensePlate() + " " + this.getVin() + " " + this.getPurchaseDate() + " " + this.getPurchasePrice();
    }

    
    
    //endregion
}

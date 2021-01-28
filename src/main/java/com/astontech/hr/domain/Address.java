package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressId")
    private Integer id;
    
    @Version
    private Integer version;
    
/*    @ManyToOne
    @JoinColumn(name = "ContactId")
    private Contact contact;*/
    
    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String addressType;
    
    public Address() {
    }
    
    public Address(String street, String street2, String city, String state, String zip, String addressType) {
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.addressType = addressType;
    }
    
    public Address(String street, String city, String state, String zip, String addressType) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.addressType = addressType;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getStreet2() {
        return street2;
    }
    
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String getAddressType() {
        return addressType;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    
/*    public Contact getContact() {
        return contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }*/
}
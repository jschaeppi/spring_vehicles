package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContactId")
    private Integer Id;
    
    @Version
    private Integer version;
    
    @OneToMany
    private List<Address> contactAddress;
    
    private String firstName;
    private String lastName;
    public Contact() {
    }
    
    public Contact(List<Address> contactAddress) {
        this.contactAddress = contactAddress;
    }
    
    public Contact(List<Address> contactAddress, String firstName, String lastName) {
        this.contactAddress = contactAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
    
    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }
    
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public List<Address> getContactAddress() {
        return contactAddress;
    }
    
    public void setContactAddress(List<Address> contactAddress) {
        this.contactAddress = contactAddress;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

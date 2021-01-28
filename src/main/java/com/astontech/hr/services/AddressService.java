package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

import java.util.List;

public interface AddressService {
    
    Address getAddress(Integer id);
    
    Iterable<Address> getAddressList();
    
    List<Address> getContactAddressList(Integer id);
    
    Address saveAddress(Address address);
    
    Iterable<Address> saveAddressList(Iterable<Address> addressList);
    
    void deleteAddress(Integer id);
    
    void deleteAddressRef(Integer id);
    
}

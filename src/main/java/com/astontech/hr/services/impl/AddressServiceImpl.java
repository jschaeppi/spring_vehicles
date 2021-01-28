package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    
    @Override
    public Address getAddress(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }
    
    @Override
    public Iterable<Address> getAddressList() {
        return addressRepository.findAll();
    }
    
    @Override
    public List<Address> getContactAddressList(Integer id) {
        return addressRepository.getAddressListByContact(id);
    }
    
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
    
    @Override
    public Iterable<Address> saveAddressList(Iterable<Address> addressList) {
        return addressRepository.saveAll(addressList);
    }
    
    @Override
    public void deleteAddress(Integer id) {
       addressRepository.deleteById(id);
    }
    
    @Override
    public void deleteAddressRef(Integer id) {
        addressRepository.deleteAddress(id);
    }
}

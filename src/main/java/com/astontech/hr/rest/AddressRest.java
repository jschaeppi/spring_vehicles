package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/address")
public class AddressRest {
    
    @Autowired
    private AddressService addressService;
    
    
    //Find All Addresses
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Address> getAddressList() {
        return addressService.getAddressList();
    }
    
    //Find By Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getAddress(@PathVariable("id") Integer id) {
        return addressService.getAddress(id);
    }
    
    //Update Address
    @RequestMapping(value = "/", method =
            RequestMethod.POST)
    public Address updateAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }
    
    //Delete Address
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteAddress(@PathVariable("id") Integer id) {
        boolean result = true;
        try {
            addressService.deleteAddressRef(id);
            addressService.deleteAddress(id);
            return result;
        } catch(Exception ex) {
            System.out.println(ex);
            result = false;
        }
        return result;
    }
}

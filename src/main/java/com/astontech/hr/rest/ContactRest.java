package com.astontech.hr.rest;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/contacts")
public class ContactRest {
    
    @Autowired
    private ContactService contactService;
    
    @Autowired
    private AddressService addressService;
    
    //Find All Contacts
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Contact> getContactList() {
        return contactService.getAllContacts();
    }
    
    //Find By Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable("id") Integer id) {
        return contactService.getContact(id);
    }
    
    //Update Contact
    @RequestMapping(value = "/", method =
            RequestMethod.POST)
    public Contact updateContact(@RequestBody Contact contact) {
        //Check if adding an address or just a new contact
        if (contact.getContactAddress() != null) {
            //Check if this is a new address or updating
            // current address
            if (contact.getContactAddress().get(0).getId() == null) {
                
                //Insert Address
                addressService.saveAddressList(contact.getContactAddress());
                
                //Add all addresses to list that link to
                // contact
                List<Address> addressList =
                        addressService.getContactAddressList(contact.getId());
                addressList.add(contact.getContactAddress().get(0));
                //Add the address list to contact
                
                contact.setContactAddress(addressList);
            } else {
                //Update address
                addressService.saveAddressList(contact.getContactAddress());
                return contactService.getContactByAddress(contact.getContactAddress().get(0).getId());
            }
        }
        return contactService.saveContact(contact);
    }
    
    //Delete Contact
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteContact(@PathVariable("id") Integer id) {
        //Deleting Address by the contact id for
        // referential integrity
        boolean result = true;
        try {
            contactService.deleteAddressByContact(id);
            contactService.deleteContact(id);
            result = true;
        } catch(Exception ex) {
            System.out.println(ex);
            result = false;
        }
        return result;
    }
}

package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public Contact getContact(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }
    
    @Override
    public Contact getContactByAddress(Integer id) {
        return contactRepository.getContactByAddressId(id);
    }
    
    @Override
    public Iterable<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    
    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
    
    @Override
    public Iterable<Contact> saveContactList(Iterable<Contact> contactList) {
        return contactRepository.saveAll(contactList);
    }
    
    @Override
    public void deleteContact(Integer Id) {
        contactRepository.deleteById(Id);
    }
    
    @Override
    public void deleteAddressByContact(Integer id) {
        contactRepository.deleteAddressByContact(id);
    }
}

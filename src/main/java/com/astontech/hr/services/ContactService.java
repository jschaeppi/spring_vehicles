package com.astontech.hr.services;

import com.astontech.hr.domain.Contact;

import java.util.List;

public interface ContactService {
    
    Contact getContact(Integer id);
    
    Iterable<Contact> getAllContacts();
    
    Contact saveContact(Contact contact);
    
    Contact getContactByAddress(Integer id);
    
    Iterable<Contact> saveContactList(Iterable<Contact> contactList);
    
    void deleteContact(Integer id);
    
    void deleteAddressByContact(Integer id);
}

package com.astontech.hr.repositories;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    
        //Deleting Address first by Contact ID before
        // deleting Contact for referential integrity
        @Transactional
        @Modifying
        @Query(value = "DELETE " +
                "FROM CONTACT_CONTACT_ADDRESS ca " +
                "WHERE ca.CONTACT_CONTACT_ID = :id",
                nativeQuery =
                true)
        void deleteAddressByContact(@Param("id") Integer id);
        
        @Query(value = "SELECT * " +
                "FROM CONTACT c " +
                "JOIN CONTACT_CONTACT_ADDRESS ca on ca" +
                ".CONTACT_CONTACT_ID = c" +
                ".CONTACT_ID " +
                "WHERE ca.CONTACT_ADDRESS_ADDRESS_ID = :id",
                nativeQuery = true)
        Contact getContactByAddressId(Integer id);
}

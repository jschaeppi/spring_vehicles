package com.astontech.hr.repositories;

import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM CONTACT_CONTACT_ADDRESS ca " +
            "WHERE " +
            "ca.CONTACT_ADDRESS_ADDRESS_ID = :id",
            nativeQuery = true)
    void deleteAddress(@Param("id") Integer id);
    
    @Query(value = "SELECT * " +
            "FROM ADDRESS a " +
            "JOIN CONTACT_CONTACT_ADDRESS ca on ca" +
            ".CONTACT_ADDRESS_ADDRESS_ID = a.ADDRESS_ID " +
            "WHERE ca.CONTACT_CONTACT_ID = :id",
            nativeQuery = true)
    List<Address> getAddressListByContact(@Param("id") Integer id);
}

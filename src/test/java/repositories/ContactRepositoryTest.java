package repositories;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ContactRepositoryTest {
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Test
    public void testContact() {
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("956 Main Ave.",
                "Apt 8",
                "Los Angeles", "CA", "90001", "Work"));
        addressRepository.saveAll(addressList);
        Contact contact = new Contact();
        Assert.isNull(contact.getId(), "This contact " +
                "has an Id");
        contact.setContactAddress(addressList);
        contactRepository.save(contact);
        Assert.notNull(contact.getId(), "This contact " +
                "doesn't have an Id");
        
        Contact fetchedContact =
                contactRepository.findById(contact.getId()).orElse(null);
        
        Assert.isTrue(fetchedContact.getId() == contact.getId(),
            "These Id's don't match");
        
        fetchedContact.getContactAddress().get(0).setCity("San Francisco");
        contactRepository.save(fetchedContact);
        
        Contact fetchedUpdatedContact =
                contactRepository.findById(fetchedContact.getId()).orElse(null);
        
        Assert.isTrue(fetchedContact.getContactAddress().get(0).getCity().equals(
                "San Francisco"), "This zip doesn't match" +
                " " +
                "criteria");
    }
}

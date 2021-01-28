package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.ContactService;
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
public class ContactServiceTest {
    
    @Autowired
    private ContactService contact1Service;
    
    @Autowired
    private AddressService addressService;
    
    @Test
    public void testContactService() {
    
        List<Address> addressList1 = new ArrayList<>();
        addressList1.add(new Address("956 Main Ave.",
                "Apt 8",
                "Los Angeles", "CA", "90001", "Work"));
        addressService.saveAddressList(addressList1);
        Contact contact1 = new Contact();
        contact1.setContactAddress(addressList1);
        
        Assert.isNull(contact1.getId(), "This contact " +
                "has an Id");
        contact1Service.saveContact(contact1);
        Assert.notNull(contact1.getId(), "This contact has" +
                " no Id");
        
        Contact fetchedContact =
                contact1Service.getContact(contact1.getId());
        Assert.isTrue(fetchedContact.getId() == contact1.getId(),
                "These object Id's don't match");
        
        fetchedContact.getContactAddress().get(0).setAddressType("Work");
        contact1Service.saveContact(fetchedContact);
        
        Contact fetchedUpdateContact =
                contact1Service.getContact(fetchedContact.getId());
        Assert.isTrue(fetchedUpdateContact.getContactAddress().get(0).getAddressType().equals("Work"), "The " +
                "updated contact type doesn't match " +
                "criteria");
    }
    
}

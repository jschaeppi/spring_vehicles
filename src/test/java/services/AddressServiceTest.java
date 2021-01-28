package services;

import com.astontech.hr.Application;
import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AddressServiceTest {
    
    @Autowired
    private AddressService addressService;
    
    @Test
    public void testAddressService() {
    
        Address address = new Address("956 Main Ave.",
                "Apt 8",
                "Los Angeles", "CA", "90001", "Work");
        Assert.isNull(address.getId(), "This address has " +
                "an Id");
        addressService.saveAddress(address);
        Assert.notNull(address.getId(), "This address has" +
                " no Id");
        
        Address fetchedAddress =
                addressService.getAddress(address.getId());
        Assert.isTrue(fetchedAddress.getId().equals(address.getId()), "These objects don't match");
        
        fetchedAddress.setState("MN");
        addressService.saveAddress(fetchedAddress);
        
        Address fetchedUpdateAddress =
                addressService.getAddress(fetchedAddress.getId());
        Assert.isTrue(fetchedUpdateAddress.getState().equals("MN"), "The updated state doesn't match criteria");
    }
    
}

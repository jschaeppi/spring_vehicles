package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
@WebAppConfiguration
public class AddressRepositoryTest {
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Test
    
    public void testAddress() {
        Address address = new Address("956 Main Ave.",
                "Apt 8",
                "Los Angeles", "CA", "90001", "Work");
        Assert.isNull(address.getId(), "This address " +
                "has an Id");
        addressRepository.save(address);
        Assert.notNull(address.getId(), "This address " +
                "doesn't have an Id");
        
        Address fetchedAddress =
                addressRepository.findById(address.getId()).orElse(null);
        
        Assert.isTrue(fetchedAddress.getId().equals(address.getId()), "These objects don't match");
        
        fetchedAddress.setZip("95645");
        addressRepository.save(fetchedAddress);
        
        Address fetchedUpdatedAddress =
                addressRepository.findById(fetchedAddress.getId()).orElse(null);
        
        Assert.isTrue(fetchedAddress.getZip().equals(
                "95645"), "This zip doesn't match " +
                "criteria");
    }
}

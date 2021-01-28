package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
@WebAppConfiguration
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setFirstName("JoeTest");
        employee.setLastName("SchaeppiTest");
        employee.setBackground("Java Developer");
        
        Assert.isNull(employee.getId(), "Employee has an " +
                "ID");
        employeeRepository.save(employee);
        Assert.notNull(employee.getId(), "This employee " +
                "doesn't have an ID");
        
        //fetch
        Employee fetchedEmployee =
                employeeRepository.findById(employee.getId()).orElse(null);
        
        Assert.notNull(fetchedEmployee, "No " +
                "employee was fetched");
        Assert.isTrue(fetchedEmployee.getId().equals(employee.getId()), "These aren't eh same employees");
        
        //update
        
        fetchedEmployee.setFirstName("Joe") ;
        employeeRepository.save(fetchedEmployee);
        
        Employee fetchedUpdatedEmployee =
                employeeRepository.findById(fetchedEmployee.getId()).orElse(null);
    
        Assert.isTrue(fetchedUpdatedEmployee.getFirstName().equals("Joe"), "These " +
                "first names " +
                "aren't the " +
                "same");
    }
}

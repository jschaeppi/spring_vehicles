package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
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
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;
    
    @Test
    public void employeeServiceSaveTest() {
        Employee employee = new Employee();
    
        Employee employee1 = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setBackground("Java Developer as well");
        
        Assert.isNull(employee1.getId(), "This employee " +
                "has an ID");
        employeeService.saveEmployee(employee1);
        Assert.notNull(employee1.getId(), "This employee " +
                "has no ID");
        
        //fetch
        Employee fetchedEmployee =
                employeeService.getEmployeeById(employee1.getId());
        Assert.notNull(fetchedEmployee, "No Employee was " +
                "found");
        Assert.isTrue(fetchedEmployee.getId().equals(employee1.getId()));
        
        //update
        fetchedEmployee.setFirstName("JohnTest");
        employeeService.saveEmployee(fetchedEmployee);
        
        Employee fetchedUpdatedEmployee =
                employeeService.getEmployeeById(fetchedEmployee.getId());
        Assert.isTrue(fetchedUpdatedEmployee.getFirstName().equals("JohnTest"));
        
        employeeService.deleteEmployee(fetchedUpdatedEmployee.getId());
        Assert.isNull(employeeService.getEmployeeById(fetchedUpdatedEmployee.getId()), "This employee still exists");
    }
    
}

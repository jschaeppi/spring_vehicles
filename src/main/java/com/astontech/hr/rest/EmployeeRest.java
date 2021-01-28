package com.astontech.hr.rest;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {
    
    @Autowired
    private EmployeeService employeeService;
    
    //FIND ALL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Employee> getAll() {
        return employeeService.listAllEmployees();
    }
    
    //FIND BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }
    
    //SAVE
    @RequestMapping(value = "/", method =
            RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    
    //DELETE
    @RequestMapping(value = "/{id}", method =
            RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") int id) {
        boolean result = false;
        try {
            employeeService.deleteEmployee(id);
            result = true;
        } catch(Exception ex) {
            System.out.println(ex);
        }
        
        return result;
    }
}

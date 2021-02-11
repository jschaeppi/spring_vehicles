package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {
    
    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    VehicleMakeService vehicleMakeService;
    
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    private ElementTypeService elementTypeService;
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private ContactService contactService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateElementAndElementTypes();
        generateVehicles();
        generateEmployees();
        generateAddressData();
    }
    
    public void generateElementAndElementTypes() {
        ElementType laptopType = new ElementType("Laptop");
        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("HT"));
        
        laptopType.setElementList(elementList);
        elementTypeService.saveElementType(laptopType);
        ElementType workType = new ElementType("Work");
        elementList.clear();
        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Computer"));
        workType.setElementList(elementList);
        elementTypeService.saveElementType(workType);
    }
    
    //Generates the complete vehicle lists
    public void generateVehicles() {
        List<VehicleMake> vehicleMakeList = new ArrayList<>();
        vehicleMakeList.add(new VehicleMake("Dodge",
                new Date()));
        vehicleMakeList.add(new VehicleMake("Toyota",
                new Date()));
        vehicleMakeList.add(new VehicleMake("Ford",
                new Date()));
        vehicleMakeList.add(new VehicleMake("Nissan",
                new Date()));
        vehicleMakeService.saveVehicleList(vehicleMakeList);
        VehicleModel vehicleModel = new VehicleModel();
        List<Vehicle> vehicleList = new ArrayList<>();
        List<VehicleModel> vehicleModelList = new ArrayList<>();
    
        for (VehicleModel vm : generateDodgeModels()) {
           vm.setVehicleMake(vehicleMakeList.get(0));
           vehicleModelService.saveVehicleModel(vm);
           for (Vehicle v : generateVehicleList()) {
               v.setVehicleModel(vm);
               vehicleService.saveVehicle(v);
           }
        }
    
        for (VehicleModel vm : generateToyotaModels()) {
            vm.setVehicleMake(vehicleMakeList.get(1));
            vehicleModelService.saveVehicleModel(vm);
            for (Vehicle v : generateVehicleList()) {
                v.setVehicleModel(vm);
                vehicleService.saveVehicle(v);
            }
        }
    
        for (VehicleModel vm : generateFordModels()) {
            vm.setVehicleMake(vehicleMakeList.get(2));
            vehicleModelService.saveVehicleModel(vm);
            for (Vehicle v : generateVehicleList()) {
                v.setVehicleModel(vm);
                vehicleService.saveVehicle(v);
            }
        }
        
    
        for (VehicleModel vm : generateNissanModels()) {
            vm.setVehicleMake(vehicleMakeList.get(3));
            vehicleModelService.saveVehicleModel(vm);
            for (Vehicle v : generateVehicleList()) {
                v.setVehicleModel(vm);
                vehicleService.saveVehicle(v);
            }
        }
        
    }
    
    //Seeds the dodge models
    public List<VehicleModel> generateDodgeModels() {
        List<VehicleModel> vehicleModelList = new ArrayList<>();
        
        VehicleModel chargerModel = new VehicleModel(
                "Charger");
        
        VehicleModel challengerModel = new VehicleModel(
                "Challenger");
        VehicleModel avengerModel = new VehicleModel(
                "Avenger");
        VehicleModel caravanModel = new VehicleModel(
                "Caravan");
        vehicleModelList.add(chargerModel);
        vehicleModelList.add(challengerModel);
        vehicleModelList.add(avengerModel);
        vehicleModelList.add(caravanModel);
        vehicleModelService.saveVehicleModelList(vehicleModelList);
        return vehicleModelList;
    }
    
    //Seeds the toyota models
    public List<VehicleModel> generateToyotaModels() {
        List<VehicleModel> vehicleModelList = new ArrayList<>();
        
        VehicleModel camryModel = new VehicleModel(
                "Camry");
        VehicleModel tundraModel = new VehicleModel(
                "Tundra");
        VehicleModel priusModel = new VehicleModel(
                "Prius");
        VehicleModel corollaModel = new VehicleModel(
                "Corolla");
        vehicleModelList.add(camryModel);
        vehicleModelList.add(tundraModel);
        vehicleModelList.add(priusModel);
        vehicleModelList.add(corollaModel);
        vehicleModelService.saveVehicleModelList(vehicleModelList);
        return vehicleModelList;
    }
    
    //Seeds the ford models
    public List<VehicleModel> generateFordModels() {
        List<VehicleModel> vehicleModelList = new ArrayList<>();
        
        VehicleModel focusModel = new VehicleModel(
                "Focus");
        VehicleModel mustangModel = new VehicleModel(
                "Mustang");
        VehicleModel rangerModel = new VehicleModel(
                "Ranger");
        VehicleModel expeditionModel = new VehicleModel(
                "Expedition");
        vehicleModelList.add(focusModel);
        vehicleModelList.add(mustangModel);
        vehicleModelList.add(rangerModel);
        vehicleModelList.add(expeditionModel);
        vehicleModelService.saveVehicleModelList(vehicleModelList);
        return vehicleModelList;
    }
    
    //Seeds the nissan models
    public List<VehicleModel> generateNissanModels() {
        List<VehicleModel> vehicleModelList = new ArrayList<>();
        
        VehicleModel sentraModel = new VehicleModel(
                "Sentra");
        VehicleModel maximaModel = new VehicleModel(
                "Maxima");
        VehicleModel rogueModel = new VehicleModel(
                "Rogue");
        VehicleModel titanModel = new VehicleModel(
                "Titan");
        vehicleModelList.add(sentraModel);
        vehicleModelList.add(maximaModel);
        vehicleModelList.add(rogueModel);
        vehicleModelList.add(titanModel);
        vehicleModelService.saveVehicleModelList(vehicleModelList);
        return vehicleModelList;
    }
    
    //Seeds the models details
    public List<Vehicle> generateVehicleList() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(2005, "BGH123",
                "2GNALBEK0E6332348", "Black", true, 2009,
                40000));
        vehicleList.add(new Vehicle(2008, "BGH092",
                "1D7HA16K74J116073", "Red", true, 2008,
                35000));
    return vehicleList;
    }
    
    public void generateEmployees() {
        
        Employee employee = new Employee();
        employee.setFirstName("Joe");
        employee.setLastName("Schaeppi");
        employee.setBackground("Java Developer");
        employeeService.saveEmployee(employee);
        
        Employee employee1 = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setBackground("Java Developer as well");
        employeeService.saveEmployee(employee1);
        
        Employee employee2 = new Employee();
        employee.setFirstName("Dan");
        employee.setLastName("Simmer");
        employee.setBackground(".Net Developer");
        employeeService.saveEmployee(employee2);
        
        Employee employee3 = new Employee();
        employee.setFirstName("Sean");
        employee.setLastName("Nilsen");
        employee.setBackground("Contact Center Engineer");
        employeeService.saveEmployee(employee3);
    }
    
    public void generateAddressData() {
        List<Address> contactAddressList1 =
                new ArrayList<>();
        List<Address> contactAddressList2 =
                new ArrayList<>();
        Address address1 = new Address("123 Main St.",
                "New York", "NY", "10001", "Home");
        
        Address address2 = new Address("115 2nd St.",
                "Rochester", "NY", "14602", "Work");
    
        Address address3 = new Address("956 Main Ave.",
                "Apt 8",
                "Los Angeles", "CA", "90001", "Work");
    
        Address address4 = new Address("123 Main St.",
                "Unit 5",
                "Cedar Rapids", "IA", "10001", "Home");
    
        Contact contact1 =
                new Contact(contactAddressList1, "John",
                        "Doe");
        Contact contact2 =
                new Contact(contactAddressList2, "Jane",
                        "Doe");
    
        contactAddressList1.add(address1);
        contactAddressList1.add(address2);
        contactAddressList2.add(address3);
        contactAddressList2.add(address4);
    
    
        addressService.saveAddressList(contactAddressList1);
        addressService.saveAddressList(contactAddressList2);
        
        contact1.setContactAddress(contactAddressList1);
        contact2.setContactAddress(contactAddressList2);
        contactService.saveContact(contact1);
        contactService.saveContact(contact2);
        
/*
        address1.setContact(contact1);
        address2.setContact(contact1);
        address3.setContact(contact2);
        address4.setContact(contact2);*/
    }
    
}

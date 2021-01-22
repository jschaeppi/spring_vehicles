package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
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
    private ElementTypeService elementTypeService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateElementAndElementTypes();
        generateVehicles();
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

        List<Vehicle> vehicleList = new ArrayList<>();
        
        for (VehicleModel vm : generateDodgeModels()) {
            for (Vehicle v : generateVehicleList()) {
                vm.setVehicleMake(vehicleMakeList.get(0));
                v.setVehicleModel(vm);
                vehicleList.add(v);
            }
        }
        vehicleService.saveVehicleList(vehicleList);
    
        vehicleList.clear();
        
        for (VehicleModel vm : generateToyotaModels()) {
            for (Vehicle v : generateVehicleList()) {
                vm.setVehicleMake(vehicleMakeList.get(1));
                v.setVehicleModel(vm);
                vehicleList.add(v);
            }
        }
        vehicleService.saveVehicleList(vehicleList);
        vehicleList.clear();
        
        for (VehicleModel vm : generateFordModels()) {
            for (Vehicle v : generateVehicleList()) {
                vm.setVehicleMake(vehicleMakeList.get(2));
                v.setVehicleModel(vm);
                vehicleList.add(v);
            }
        }
        vehicleService.saveVehicleList(vehicleList);
        vehicleList.clear();
        
        for (VehicleModel vm : generateNissanModels()) {
            for (Vehicle v : generateVehicleList()) {
                vm.setVehicleMake(vehicleMakeList.get(3));
                v.setVehicleModel(vm);
                vehicleList.add(v);
            }
        }
        vehicleService.saveVehicleList(vehicleList);
    
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
}

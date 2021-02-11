package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleMakeVO;
import com.astontech.hr.domain.VO.VehicleModelVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehicleController {
    
    @Autowired
    VehicleMakeService vehicleMakeService;
    
    @Autowired
    VehicleService vehicleService;
    
    @Autowired
    VehicleModelService vehicleModelService;
    
    
    @Autowired
    VehicleRepository vehicleRepository;
    //region GET REQUESTS
    @RequestMapping(value = "/admin/vehicles/vehiclelist",
            method = RequestMethod.GET)
    public String getVehicles(Model model) {
        model.addAttribute("allVehicles",
                vehicleService.listAllVehicles()
                );
        model.addAttribute("addMake", new VehicleMakeVO());
        model.addAttribute("addModel",
                new VehicleModelVO());
        return "admin/vehicles/vehicle_list";
    }
    
    @RequestMapping(value = "/admin/models",
            method = RequestMethod.GET)
    public String getModels(Model model) {
        model.addAttribute("vehicleModels",
                vehicleModelService.listAllModels());
        return "admin/vehicles/models/vehicleModel_list";
    }
    
    @RequestMapping(value = "/admin/makes",
            method = RequestMethod.GET)
    public String getMakes(Model model) {
        model.addAttribute("vehicleMakes",
                vehicleMakeService.listAll());
        return "admin/vehicles/makes/vehicleMake_list";
    }
    
    @RequestMapping(value = "/admin/vehicles/add",
            method = RequestMethod.GET)
    public String getVehicle(VehicleVO vehicleVO,
                             Model model
    ) {
        model.addAttribute("vehicleVO",
                vehicleVO);
        return "admin/vehicles/vehicle_add";
    }
    
    @RequestMapping(value = "/admin/vehicles/vehicle/{id}",
            method = RequestMethod.GET)
    public String getAddVehicle(@PathVariable int id,
                                 Model model) {
        Vehicle selectedVehicle =
                vehicleService.findVehicleById(id);
        model.addAttribute("vehicleDetails",
                selectedVehicle);
        return "admin/vehicles/vehicle_view";
    }
    
    @RequestMapping(value = "/admin/vehicles/edit/{id}",
            method = RequestMethod.GET)
    public String getEditVehicle(@PathVariable int id,
                                 Model model) {
        Vehicle selectedVehicle =
                vehicleService.findVehicleById(id);
        model.addAttribute("vehicleDetails",
                selectedVehicle);

        System.out.println(selectedVehicle.getVehicleId());
        System.out.println(selectedVehicle.getVehicleModel());
        System.out.println(selectedVehicle.getVehicleModel().getVehicleMake().getVehicleMakeName());
        return "admin/vehicles/vehicle_edit";
    }
    
    @RequestMapping(value = "/admin/models/edit/{id}",
            method = RequestMethod.GET)
    public String getEditModel(@PathVariable int id,
                                 Model model) {
        VehicleModel selectedModel =
                vehicleModelService.getVehicleModelById(id);
        model.addAttribute("vehicleModels",
                selectedModel);
        return "admin/vehicles/models/edit";
    }
    
    @RequestMapping(value = "/admin/makes/edit/{id}",
            method = RequestMethod.GET)
    public String getEditMake(@PathVariable int id,
                                 Model model) {
        VehicleMake selectedMake =
                vehicleMakeService.getVehicleById(id);
        model.addAttribute("vehicleMakes",
                selectedMake);
        return "admin/vehicles/makes/edit";
    }
    
    @RequestMapping(value = "/admin/vehicles/delete/{id}",
            method = RequestMethod.GET)
    public String deleteVehicle(@PathVariable("id") Integer id) {
        vehicleService.deleteVehicleById(id);
        return "redirect:/admin/vehicles/vehiclelist";
    }
    
    @RequestMapping(value = "/admin/models/delete/{id}",
            method = RequestMethod.GET)
    public String deleteModel(@PathVariable("id") int id) {
        System.out.println("Deleted Successfully");
        vehicleService.deleteVehicleByModelId(id);
        vehicleModelService.deleteVehicleModelById(id);
        return "redirect:/admin/models";
    }
    
    @RequestMapping(value = "/admin/makes/delete/{id}",
            method = RequestMethod.GET)
    public String deleteMake(@PathVariable("id") int id) {
        System.out.println("Deleted Successfully");
        
        //Loops through the list of models that were
        // found by the make id to delete every vehicle
        // details by it's associated model
        for (VehicleModel vmo :
                vehicleModelService.findVehicleIdByModelId(id)) {
                vehicleService.deleteVehicleByModelId(vmo.getVehicleModelId());
        }
        System.out.println("Finished deleting vehicle " +
                "details per model");
        vehicleModelService.deleteModelByMakeId(id);
        System.out.println("Finished deleting models by " +
                "the make Id");
        vehicleMakeService.deleteVehicleMakeById(id);
        System.out.println("Finished deleting make by " +
                "it's Id");
        return "redirect:/admin/makes";
    }
    //endregion
    
    //region CUSTOM MODEL ATTRIBUTES
    @ModelAttribute("vehicleModels")
    public List<String> getVehicleModelList() {
        List<String> vehicleModelList = new ArrayList<>();
        for (VehicleModel vmo : vehicleModelService.listAllModels()) {
            vehicleModelList.add(vmo.getVehicleModelName());
        }
        return vehicleModelList;
    }
    
    @ModelAttribute("vehicleMakes")
    public List<String> getVehicleMakeList() {
        List<String> vehicleMakeList =
                new ArrayList<>();
        for (VehicleMake vma : vehicleMakeService.listAll()) {
            vehicleMakeList.add(vma.getVehicleMakeName());
        }
        return vehicleMakeList;
    }
    
    //endregion
    
    //region POST REQUESTS
    @RequestMapping(value = "/admin/vehicles/add",
            method = RequestMethod.POST)
    public String postAddVehicle(VehicleVO vehicleVO,
                                 Model model) {
        Vehicle vehicle = new Vehicle(
                vehicleVO.getYear(),
                vehicleVO.getLicensePlate(),
                vehicleVO.getVin(),
                vehicleVO.getColor(),
                vehicleVO.getIsPurchase(),
                vehicleVO.getPurchaseDate(),
                vehicleVO.getPurchasePrice()
        );
        VehicleModel vehicleModel =
                vehicleModelService.findModelByName(vehicleVO.getVehicleModel());
        vehicleModel.setVehicleMake(vehicleMakeService.findVehicleMakeByName(vehicleVO.getVehicleMake()));
        vehicle.setVehicleModel(vehicleModel);
        vehicleService.saveVehicle(vehicle);
        return "redirect:/admin/vehicles/vehiclelist";
    }
    
    @RequestMapping(value = "/admin/vehicles/update",
            method = RequestMethod.POST)
    public String updateVehicle(Vehicle vehicle,
                                Model model
                                ) {
            vehicleService.saveVehicle(vehicle);
        model.addAttribute("successAlert", "visible");
        return "redirect:/admin/vehicles/vehicle/" + vehicle.getVehicleId();
    }
    
    @RequestMapping(value = "/admin/models/add",
            method = RequestMethod.POST)
    public String postAddModel (Model model,
                                VehicleModelVO vehicleModelVO
                                ) {
        if (vehicleModelVO.getVehicleModelName() == "") {
            model.addAttribute("errorAlert", "visible");
            return "redirect:/admin/vehicles/vehiclelist";
        }
        VehicleModel vehicleModel = new VehicleModel();
        VehicleMake vehicleMake =
                vehicleMakeService.findVehicleMakeByName(vehicleModelVO.getVehicleMakeName());
        vehicleModel.setVehicleModelName(vehicleModelVO.getVehicleModelName());
        vehicleModel.setVehicleMake(vehicleMake);
        vehicleModelService.saveVehicleModel(vehicleModel);
        model.addAttribute("successAlert", "visible");
        System.out.println("Updated Successfully.");
        return "redirect:/admin/models";
    }
    
    @RequestMapping(value = "/admin/models/update",
            method = RequestMethod.POST)
    public String updateModel(VehicleModel vehicleModel,
                              Model model) {
        System.out.println("Updated Successfully");
        vehicleModelService.saveVehicleModel(vehicleModel);
        model.addAttribute("successAlert", "visibile");
        return "redirect:/admin/models";
    }
    
    @RequestMapping(value = "/admin/makes/add",
            method = RequestMethod.POST)
    public String postAddVehicle( Model model,
                                  VehicleMakeVO vehicleMakeVO
                                ) {
        if (vehicleMakeVO.getVehicleMake() == "") {
            model.addAttribute("errorAlert", "visible");
            return "redirect:/admin/vehicles/vehiclelist";
        }
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeName(vehicleMakeVO.getVehicleMake());
        vehicleMake.setCreateDate(vehicleMakeVO.getCreateDate());
        vehicleMakeService.saveMake(vehicleMake);
        model.addAttribute("addMake", new VehicleMakeVO());
        return "redirect:/admin/makes";
    }
    
    @RequestMapping(value = "/admin/makes/update",
            method = RequestMethod.POST)
    public String updateMake(VehicleMake vehicleMake) {
        System.out.println("Updated Successfully");
        vehicleMakeService.saveMake(vehicleMake);
        return "redirect:/admin/makes";
    }
    
    //endregion
}

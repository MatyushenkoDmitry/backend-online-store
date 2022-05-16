package com.example.postgrescodefirst.Online.Store.controller;


import com.example.postgrescodefirst.Online.Store.model.Manufacturer;
import com.example.postgrescodefirst.Online.Store.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {

    @Autowired
    private IManufacturerService manufacturerService;



    @GetMapping("/manufacturers")
    public Iterable<Manufacturer> getAllManufacturers()
    {
        return manufacturerService.findAll();
    }


    @GetMapping("/manufacturer/{id}")
    public Manufacturer getById(@PathVariable(name = "id") int id)
    {
        return manufacturerService.find(id);
    }
}

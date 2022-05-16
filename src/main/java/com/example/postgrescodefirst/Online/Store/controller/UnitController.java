package com.example.postgrescodefirst.Online.Store.controller;

import com.example.postgrescodefirst.Online.Store.model.Unit;
import com.example.postgrescodefirst.Online.Store.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitController {


    @Autowired
    private IUnitService unitService;


    @GetMapping("/units")
    public Iterable<Unit> getAllUnits()
    {
        return unitService.findAll();
    }


    @GetMapping("/units/{id}")
    public Unit getById(@PathVariable(name = "id") int id)
    {
        return unitService.find(id);
    }
}

package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Manufacturer;
import com.example.postgrescodefirst.Online.Store.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ManufacturerService implements IManufacturerService{


    @Autowired
    private ManufacturerRepository manufacturerRepository;


    @Override
    public List<Manufacturer> findAll() {
        return  (List<Manufacturer>) manufacturerRepository.findAll() ;
    }

    @Override
    public Manufacturer find(int id) {
        try {
            return manufacturerRepository.findById(id).get();

        }
        catch (NoSuchElementException ex)
        {
            return new Manufacturer(0,"No Such Manufacturer" );
        }
    }
}

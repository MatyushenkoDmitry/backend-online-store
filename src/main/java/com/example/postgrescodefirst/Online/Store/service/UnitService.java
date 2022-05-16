package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Unit;
import com.example.postgrescodefirst.Online.Store.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UnitService implements IUnitService{


    @Autowired
    private UnitRepository unitRepository;



    @Override
    public List<Unit> findAll() {
        return  (List<Unit>) unitRepository.findAll() ;
    }

    @Override
    public Unit find(int id) {
        try {
            return unitRepository.findById(id).get();

        }
        catch (NoSuchElementException ex)
        {
            return new Unit(0,"No Such Unit" );
        }
    }
}

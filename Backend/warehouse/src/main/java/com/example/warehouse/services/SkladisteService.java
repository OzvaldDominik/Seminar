package com.example.warehouse.services;

import com.example.warehouse.entities.Skladiste;
import com.example.warehouse.repositories.SkladisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkladisteService {
    private final SkladisteRepository skladisteRepository;
    @Autowired
    public SkladisteService(SkladisteRepository skladisteRepository) {
        this.skladisteRepository = skladisteRepository;
    }

    public List<Skladiste> getSkaldiste(){
        return skladisteRepository.findAll();
    }
    public Skladiste getSkladisteById( Long id){
        return skladisteRepository.findById(id).orElse(null);
    }

    public List<Skladiste> getSkaldisteBySkladitsarId(Long skladistraId){
        return skladisteRepository.findAllBySkladistarIdSkladistar(skladistraId);
    }

}

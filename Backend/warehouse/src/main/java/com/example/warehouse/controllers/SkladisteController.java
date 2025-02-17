package com.example.warehouse.controllers;

import com.example.warehouse.entities.Skladiste;
import com.example.warehouse.services.SkladisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/skladiste")
public class SkladisteController {
    private final SkladisteService skladisteService;

    @Autowired
    public SkladisteController(SkladisteService skladisteService) {
        this.skladisteService = skladisteService;
    }
    @GetMapping
    public List<Skladiste> getSkaldiste(){
        return skladisteService.getSkaldiste();
    }
    @GetMapping("/{id}")
    public Skladiste getSkladisteById(@PathVariable Long id){
        return skladisteService.getSkladisteById(id);
    }

    @GetMapping("/skladistar/{skalidstarId}")
    public List<Skladiste> getSkladisteBySkladistarId(@PathVariable Long skalidstarId){
        return skladisteService.getSkaldisteBySkladitsarId(skalidstarId);
    }


}

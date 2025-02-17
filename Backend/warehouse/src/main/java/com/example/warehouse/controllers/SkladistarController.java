package com.example.warehouse.controllers;

import com.example.warehouse.entities.Skladistar;
import com.example.warehouse.entities.Skladiste;
import com.example.warehouse.models.LoginInfo;
import com.example.warehouse.services.SkladistarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/skladistar")
public class SkladistarController {
    private final SkladistarService skladistarService;

    @Autowired
    public SkladistarController(SkladistarService skladistarService) {
        this.skladistarService = skladistarService;
    }

    @PostMapping("/login")
    public ResponseEntity<Skladistar> login (@RequestBody LoginInfo loginRequest){
        Skladistar skladistar = skladistarService.findSkladistarByLoginInfo(loginRequest.getUsername(), loginRequest.getPassword());
        if (skladistar!=null){
            return ResponseEntity.ok(skladistar);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}



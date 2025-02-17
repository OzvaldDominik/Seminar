package com.example.warehouse.services;

import com.example.warehouse.entities.Skladistar;
import com.example.warehouse.repositories.SkladistarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkladistarService {
    private final SkladistarRepository skladistarRpository;

    @Autowired
    public SkladistarService(SkladistarRepository skladistarRpository) {
        this.skladistarRpository = skladistarRpository;

    }

    public Skladistar findSkladistarByLoginInfo(String username, String password) {
        return skladistarRpository.findByKorisnickoImeSkladistarAndLozinkaSkladistar(username, password);
    }


}


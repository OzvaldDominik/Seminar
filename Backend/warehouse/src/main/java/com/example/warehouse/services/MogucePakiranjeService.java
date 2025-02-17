package com.example.warehouse.services;

import com.example.warehouse.entities.Artikl;
import com.example.warehouse.entities.MogucePakirtanje;
import com.example.warehouse.models.CleanDocument;
import com.example.warehouse.models.CleanPackaging;
import com.example.warehouse.models.PackingNameOnly;
import com.example.warehouse.repositories.MogucePakiranjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MogucePakiranjeService {
    private final MogucePakiranjeRepository mogucePakiranjeRepository;

    @Autowired
    public MogucePakiranjeService(MogucePakiranjeRepository mogucePakiranjeRepository) {
        this.mogucePakiranjeRepository = mogucePakiranjeRepository;
    }
    public CleanPackaging getPackingById(Long idPacking){
        MogucePakirtanje mogucePakirtanje = mogucePakiranjeRepository.findById(idPacking).orElse(null);
        CleanPackaging cleanPackaging = null;
        if (mogucePakirtanje!=null){
            cleanPackaging=new CleanPackaging(mogucePakirtanje);
        }
        return cleanPackaging;
    }

    public List<CleanPackaging> getMogucePakiranjeByArtikl(Long idArtikl){
        List<CleanPackaging> cleanPackagings = new ArrayList<>();
        List<MogucePakirtanje> mogucePakirtanjeList = mogucePakiranjeRepository.findAllByArtiklIdArtikl(idArtikl);

        for (MogucePakirtanje pakirtanje : mogucePakirtanjeList){
            cleanPackagings.add(new CleanPackaging(pakirtanje));
        }
        return cleanPackagings;
    }

    public List<PackingNameOnly> getPackingNamesForWarehouse(Long idWarehouse){
        List<MogucePakirtanje> mogucePakirtanjeList=mogucePakiranjeRepository.findAllBySkladisteIdSkladiste(idWarehouse);
        List<PackingNameOnly> packingNameOnlyList= new ArrayList<>();
        for (MogucePakirtanje mogucePakirtanje : mogucePakirtanjeList){
            packingNameOnlyList.add(new PackingNameOnly(mogucePakirtanje));
        }
        return packingNameOnlyList;
    }

    public List<CleanPackaging> getAllPackingForIdPacking(Long idPacking){
        List<CleanPackaging> cleanPackagingList= new ArrayList<>();
        MogucePakirtanje mogucePakirtanje = mogucePakiranjeRepository.findById(idPacking).orElse(null);
        List<MogucePakirtanje> mogucePakirtanjeList= mogucePakiranjeRepository.findAllByArtiklIdArtikl(mogucePakirtanje.getArtikl().getIdArtikl());
        for(MogucePakirtanje pakirtanje : mogucePakirtanjeList){
            cleanPackagingList.add(new CleanPackaging(pakirtanje));
        }
        return cleanPackagingList;
    }
}

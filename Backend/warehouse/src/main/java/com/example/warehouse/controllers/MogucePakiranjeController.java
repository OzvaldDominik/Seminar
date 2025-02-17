package com.example.warehouse.controllers;

import com.example.warehouse.models.CleanPackaging;
import com.example.warehouse.models.PackingNameOnly;
import com.example.warehouse.services.MogucePakiranjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mogucePakiranje")
public class MogucePakiranjeController {
    private final MogucePakiranjeService mogucePakiranjeService;
    @Autowired
    public MogucePakiranjeController(MogucePakiranjeService mogucePakiranjeService) {
        this.mogucePakiranjeService = mogucePakiranjeService;
    }

    @GetMapping("/{idPakiranje}")
    public CleanPackaging getCleanPacking(@PathVariable Long idPakiranje){
        return mogucePakiranjeService.getPackingById(idPakiranje);
    }

    @GetMapping("/artikl/{idArtikl}")
    public List<CleanPackaging> getMogucePakiranjeByArtikId(@PathVariable Long idArtikl){
        return mogucePakiranjeService.getMogucePakiranjeByArtikl(idArtikl);
    }
    @GetMapping("/names/{idSkladiste}")
    public List<PackingNameOnly> getPackingNames (@PathVariable Long idSkladiste){
        return mogucePakiranjeService.getPackingNamesForWarehouse(idSkladiste);
    }
    @GetMapping("/related/{idPacking}")
    public List<CleanPackaging> getAllRelatedPacking(@PathVariable Long idPacking){
        return mogucePakiranjeService.getAllPackingForIdPacking(idPacking);
    }
}

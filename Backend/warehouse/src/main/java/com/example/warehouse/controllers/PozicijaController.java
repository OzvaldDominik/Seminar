package com.example.warehouse.controllers;

import com.example.warehouse.entities.Pozicija;
import com.example.warehouse.models.LabeledPosition;
import com.example.warehouse.models.PositionAndAmount;
import com.example.warehouse.services.PozicijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pozocija")
public class PozicijaController {
    private final PozicijaService pozicijaService;

    @Autowired
    public PozicijaController(PozicijaService pozicijaService) {
        this.pozicijaService = pozicijaService;
    }

    @GetMapping("/skladiste/{skaldisteId}")
    public List<PositionAndAmount> getPozicijaBySkladisteId(@PathVariable Long skaldisteId){
        return pozicijaService.getPositionInfoForWarehouse(skaldisteId);
    }
    @GetMapping("/skladiste/labels/{skaldisteId}")
    public List<LabeledPosition> getLabeledPositionsBySkladisteId(@PathVariable Long skaldisteId){
        return pozicijaService.getPositionLabels(skaldisteId);
    }

    @GetMapping("/artikl/{idArtikl}")
    public List<PositionAndAmount> getPositionAndAmountByArtikl(@PathVariable Long idArtikl){
        return pozicijaService.getPositionAndAmountForArtikl(idArtikl);
    }
    @GetMapping("/pakiranje/{idPakiranje}")
    public List<PositionAndAmount> getPositionAndAmountByIdPakiranje(@PathVariable Long idPakiranje){
        return pozicijaService.getPositionAndAmountForPakiranje(idPakiranje);
    }
}

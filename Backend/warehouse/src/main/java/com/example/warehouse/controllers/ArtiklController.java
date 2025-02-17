package com.example.warehouse.controllers;

import com.example.warehouse.entities.Artikl;
import com.example.warehouse.models.CleanArtikl;
import com.example.warehouse.models.StringResponse;
import com.example.warehouse.services.ArtiklService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/artikl")
public class ArtiklController {
    private final ArtiklService artiklService;
    @Autowired
    public ArtiklController(ArtiklService artiklService) {
        this.artiklService = artiklService;
    }

    @GetMapping("/{idArtikl}")
    public CleanArtikl getArtikl(@PathVariable Long idArtikl){
        return artiklService.getArtiklById(idArtikl);
    }

    @GetMapping("/skladiste/{idSkaldiste}")
    public List<CleanArtikl> getArtiklsBySkaldiste(@PathVariable Long idSkaldiste){
        return artiklService.getArtiklsByWarehouseId(idSkaldiste);
    }

    @PostMapping("/update/limits")
    public StringResponse upadateLimits (@RequestBody CleanArtikl cleanArtikl){
        if(artiklService.updateArtiklLimits(cleanArtikl)){
            return new StringResponse("Artikl updated successfully.");
        }
        else {
            return new StringResponse("Error while updating limits");
        }
    }

    @GetMapping("/skladiste/warning/{idSkladiste}")
    public List<CleanArtikl> getLimitWarning(@PathVariable Long idSkladiste){
        return artiklService.getNearLimitArtikl(idSkladiste);
    }

}

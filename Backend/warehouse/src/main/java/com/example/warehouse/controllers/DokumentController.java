package com.example.warehouse.controllers;

import com.example.warehouse.entities.Dokument;
import com.example.warehouse.models.CleanDocument;
import com.example.warehouse.models.PostDocument;
import com.example.warehouse.models.StringResponse;
import com.example.warehouse.services.DokumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/dokument")
public class DokumentController {
    private final DokumentService dokumentService;

    @Autowired
    public DokumentController(DokumentService dokumentService) {
        this.dokumentService = dokumentService;
    }
    @GetMapping("skladiste/{idSkladiste}")
    public List<CleanDocument> getDokumnetBySkaldiste(@PathVariable Long idSkladiste){
        return dokumentService.getDokumnetBySkladiste(idSkladiste);
    }
    @GetMapping("/{idDokumnet}")
    public CleanDocument getDokumnetById(@PathVariable Long idDokumnet){
        return dokumentService.getDocumentById(idDokumnet);
    }
    @PostMapping("/create")
    public StringResponse createDocument(@RequestBody PostDocument postDocument){
        if(dokumentService.createDokument(postDocument)){
            return new StringResponse("Document created successfully");
        }
        else {
            return new StringResponse("Unable to create document");
        }
    }

    @GetMapping("/artikl/{idArtikl}")
    public List<CleanDocument> getDocmuentsByArtikl(@PathVariable Long idArtikl){
        return dokumentService.getDocumentsByArtikl(idArtikl);
    }
}

package com.example.warehouse.controllers;

import com.example.warehouse.entities.StavkaPromjene;
import com.example.warehouse.models.CleanDocumentItem;
import com.example.warehouse.services.StavkaPromjeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stavkaPromjene")
public class StavkaPromjeneController {
    private final StavkaPromjeneService stavkaPromjeneService;
    @Autowired
    public StavkaPromjeneController(StavkaPromjeneService stavkaPromjeneService) {
        this.stavkaPromjeneService = stavkaPromjeneService;
    }

    @GetMapping("/dokumnet/{idDokument}")
    public List<CleanDocumentItem> getStavkaPromjenByDokument(@PathVariable Long idDokument){
        return stavkaPromjeneService.getAllStavkaPromjeneByDokumnet(idDokument);
    }
}

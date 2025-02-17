package com.example.warehouse.services;

import com.example.warehouse.entities.StavkaPromjene;
import com.example.warehouse.models.CleanDocumentItem;
import com.example.warehouse.repositories.StavkaPromjeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StavkaPromjeneService {
    private final StavkaPromjeneRepository stavkaPromjeneRepository;
    @Autowired
    public StavkaPromjeneService(StavkaPromjeneRepository stavkaPromjeneRepository) {
        this.stavkaPromjeneRepository = stavkaPromjeneRepository;
    }

    public List<CleanDocumentItem> getAllStavkaPromjeneByDokumnet(Long idDokument){
        List<StavkaPromjene> stavkePromjene = stavkaPromjeneRepository.findAllByDokumentIdDokument(idDokument);
        List<CleanDocumentItem> cleanDocumentItems = new ArrayList<>();
        for(StavkaPromjene stavkaPromjene : stavkePromjene){
            cleanDocumentItems.add(new CleanDocumentItem(stavkaPromjene));
        }
        return cleanDocumentItems;
    }
}

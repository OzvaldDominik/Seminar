package com.example.warehouse.services;

import com.example.warehouse.entities.*;
import com.example.warehouse.models.CleanDocument;
import com.example.warehouse.models.PostDocument;
import com.example.warehouse.models.PostDocumentItem;
import com.example.warehouse.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DokumentService {
    private final DokumentRepository dokumentRepository;
    private final StavkaPromjeneRepository stavkaPromjeneRepository;
    private final SkladisteRepository skladisteRepository;
    private final SkladistarRepository skladistarRepository;

    private final MogucePakiranjeRepository mogucePakiranjeRepository;
    private final PozicijaReopository pozicijaReopository;


    @Autowired
    public DokumentService(DokumentRepository dokumentRepository, StavkaPromjeneRepository stavkaPromjeneRepository, SkladisteRepository skladisteRepository, SkladistarRepository skladistarRepository, MogucePakiranjeRepository mogucePakiranjeRepository, PozicijaReopository pozicijaReopository) {
        this.dokumentRepository = dokumentRepository;
        this.stavkaPromjeneRepository = stavkaPromjeneRepository;
        this.skladisteRepository = skladisteRepository;
        this.skladistarRepository = skladistarRepository;
        this.mogucePakiranjeRepository = mogucePakiranjeRepository;
        this.pozicijaReopository = pozicijaReopository;
    }

    public List<CleanDocument> getDokumnetBySkladiste(Long idSkladiste){
        List<Dokument> dokuments = dokumentRepository.findAllBySkladisteIdSkladiste(idSkladiste);
        List<CleanDocument> cleanDocuments = new ArrayList<>();

        for (Dokument dokument: dokuments){
            cleanDocuments.add(new CleanDocument(dokument));
        }
        return cleanDocuments;
    }

    public CleanDocument getDocumentById(Long idDokumnet){
        return new CleanDocument(dokumentRepository.findById(idDokumnet).orElse(new Dokument()));
    }

    public Boolean createDokument(PostDocument postDocument){
        Dokument dokumnet= new Dokument();
        dokumnet.setVreijemeDokument(LocalDateTime.now());
        dokumnet.setOpisDokument(postDocument.getOpisDokument());
        dokumnet.setTipDokumenta(postDocument.getTipDokumenta());

        Skladiste skladiste = skladisteRepository.findById(postDocument.getIdSkladiste()).orElse(null);
        if (skladiste==null) return false;
        dokumnet.setSkladiste(skladiste);

        Skladistar skladistar = skladistarRepository.findById(postDocument.getIdSkladistar()).orElse(null);
        if(skladistar==null)return false;
        dokumnet.setSkladistar(skladistar);

        dokumnet = dokumentRepository.save(dokumnet);

        for(PostDocumentItem postDocumentItem : postDocument.getPostDocumentItems()){
            StavkaPromjene stavkaPromjene = new StavkaPromjene();
            stavkaPromjene.setDokument(dokumnet);
            stavkaPromjene.setRazlika(postDocumentItem.getRazlika());

            Pozicija pozicija = pozicijaReopository.findById(postDocumentItem.getIdPozicija()).orElseThrow(()-> new RuntimeException("Pozicija not found"));
            stavkaPromjene.setPozicija(pozicija);

            MogucePakirtanje mogucePakirtanje = mogucePakiranjeRepository.findById(postDocumentItem.getIdMogucePakiranje()).orElseThrow(()-> new RuntimeException("MogucePakirtanje not found"));
            stavkaPromjene.setMogucePakirtanje(mogucePakirtanje);
            mogucePakirtanje.setKolicinaPakiranja(mogucePakirtanje.getKolicinaPakiranja()+postDocumentItem.getRazlika());

            stavkaPromjeneRepository.save(stavkaPromjene);
            mogucePakiranjeRepository.save(mogucePakirtanje);
        }


        return true;
    }
    public List<CleanDocument> getDocumentsByArtikl(Long idArtikl){
        return dokumentRepository.findDokumnetByArtikl(idArtikl);
    }

}

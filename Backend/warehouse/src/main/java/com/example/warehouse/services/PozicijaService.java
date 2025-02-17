package com.example.warehouse.services;

import com.example.warehouse.entities.Pozicija;
import com.example.warehouse.entities.StavkaPromjene;
import com.example.warehouse.models.LabeledPosition;
import com.example.warehouse.models.PositionAndAmount;
import com.example.warehouse.repositories.PozicijaReopository;
import com.example.warehouse.repositories.StavkaPromjeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PozicijaService {
    private final PozicijaReopository pozicijaReopository;
    private final StavkaPromjeneRepository stavkaPromjeneRepository;

    @Autowired
    public PozicijaService(PozicijaReopository pozicijaReopository, StavkaPromjeneRepository stavkaPromjeneRepository) {
        this.pozicijaReopository = pozicijaReopository;
        this.stavkaPromjeneRepository = stavkaPromjeneRepository;
    }

    public List<Pozicija> getPozicijaBySkladisteId(Long skladisteId){
        return pozicijaReopository.findAllBySkladisteIdSkladiste(skladisteId);
    }

    public List<PositionAndAmount> getPositionInfoForWarehouse(Long idSkladiste){
//        List<PositionAndAmount> positionAndAmounts= stavkaPromjeneRepository.findPositionAndAmountForSkladiste(idSkladiste);
//        List<Pozicija> pozicije= pozicijaReopository.findAllBySkladisteIdSkladiste(idSkladiste);
//
//        for (Pozicija pozicija : pozicije){
//            List<StavkaPromjene> stavkePromjene= stavkaPromjeneRepository.findAllByPozicijaIdPozicija(pozicija.getIdPozicija());
//            Integer zbrojRazlika=stavkePromjene.stream().mapToInt(StavkaPromjene::getRazlika).sum();
//            StavkaPromjene mostReacentStacvka= getMostreacentStavka(stavkePromjene);
//            positionAndAmounts.add(new PositionAndAmount(pozicija.getIdPozicija(),pozicija.getOznakaPozicija(),
//                    mostReacentStacvka.getMogucePakirtanje().getIdMogucePakiranje(),mostReacentStacvka.getMogucePakirtanje().getImeMogucePakiranje(),
//                     zbrojRazlika));
//        }

        return stavkaPromjeneRepository.findPositionAndAmountForSkladiste(idSkladiste);
    }
//    private static StavkaPromjene getMostreacentStavka(List<StavkaPromjene> stavkePromjene){
//        StavkaPromjene mostReacnetStavka= stavkePromjene.getFirst();
//
//        for (StavkaPromjene stavka : stavkePromjene){
//            if(stavka.getDokument().getVreijemeDokument().isAfter(mostReacnetStavka.getDokument().getVreijemeDokument())){
//                mostReacnetStavka=stavka;
//
//            }
//        }
//        return mostReacnetStavka;
//    }
    public List<LabeledPosition> getPositionLabels(Long idSkladiste){
        List<Pozicija> pozicijaList = pozicijaReopository.findAllBySkladisteIdSkladiste(idSkladiste);
        List<LabeledPosition> labeledPositions=new ArrayList<>();
        for (Pozicija pozicija : pozicijaList){
            labeledPositions.add(new LabeledPosition(pozicija));
        }
        return labeledPositions;
    }

    public List<PositionAndAmount> getPositionAndAmountForArtikl(Long idArtikl){
        return stavkaPromjeneRepository.findPositionAndAmountForArtikl(idArtikl);
    }
    public List<PositionAndAmount> getPositionAndAmountForPakiranje(Long idPakiranje){
        return stavkaPromjeneRepository.findPositionAndAmountForPakiranje(idPakiranje);
    }
}

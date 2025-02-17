package com.example.warehouse.services;

import com.example.warehouse.entities.Artikl;
import com.example.warehouse.entities.MogucePakirtanje;
import com.example.warehouse.models.CleanArtikl;
import com.example.warehouse.repositories.ArtiklRepository;
import com.example.warehouse.repositories.MogucePakiranjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtiklService {
    private final ArtiklRepository artiklRepository;
    private final MogucePakiranjeRepository mogucePakiranjeRepository;
    @Autowired
    public ArtiklService(ArtiklRepository artiklRepository, MogucePakiranjeRepository mogucePakiranjeRepository) {
        this.artiklRepository = artiklRepository;
        this.mogucePakiranjeRepository = mogucePakiranjeRepository;
    }
    public CleanArtikl getArtiklById (Long idArtikl){
        Artikl artikl =artiklRepository.findById(idArtikl).orElse(null);
        List <MogucePakirtanje> pakirtanjaZaArtikl = mogucePakiranjeRepository.findAllByArtiklIdArtikl(artikl.getIdArtikl());
        int kolicina=0;
        for (MogucePakirtanje pk : pakirtanjaZaArtikl){
            kolicina=kolicina+ pk.getKolicinaPakiranja()* pk.getBrojArtikala();
        }
        return new CleanArtikl(artikl,kolicina);
    }

    public List<CleanArtikl> getArtiklsByWarehouseId(Long IdWarehouse){
        Set<Artikl> artiklSet = new HashSet<Artikl>();

        List<MogucePakirtanje> pkiranja = mogucePakiranjeRepository.findAllBySkladisteIdSkladiste(IdWarehouse);

        for(MogucePakirtanje pakirtanje : pkiranja){
            artiklSet.add(artiklRepository.findById(pakirtanje.getArtikl().getIdArtikl()).orElse(null));
        }

        List<CleanArtikl> cleanArtiklList = new ArrayList<>();
        for( Artikl artikl : artiklSet){
            List <MogucePakirtanje> pakirtanjaZaArtikl = mogucePakiranjeRepository.findAllByArtiklIdArtikl(artikl.getIdArtikl());
            int kolicina=0;
            for (MogucePakirtanje pk : pakirtanjaZaArtikl){
                kolicina=kolicina+ pk.getKolicinaPakiranja()* pk.getBrojArtikala();
            }
            cleanArtiklList.add(new CleanArtikl(artikl,kolicina));

        }
        Collections.sort(cleanArtiklList);


        return cleanArtiklList;
    }

    public Boolean updateArtiklLimits(CleanArtikl cleanArtikl){
        Artikl artikl = artiklRepository.findById(cleanArtikl.getIdArtikl()).orElse(null);
        if (artikl==null) return false;

        artikl.setDonjaGranica(cleanArtikl.getDonjaGranica());
        artikl.setGornjaGranica(cleanArtikl.getGornjaGranica());

        artiklRepository.save(artikl);
        return true;
    }

    public List<CleanArtikl> getNearLimitArtikl(Long idWarehouse){
        List<CleanArtikl> allArtikls=getArtiklsByWarehouseId(idWarehouse);
        List<CleanArtikl> nearLimitArtikls=new ArrayList<>();
        for(CleanArtikl artikl : allArtikls){
            if(artikl.getDonjaGranica()!=null && artikl.getUkupnaKolicina()<(1.1*artikl.getDonjaGranica())){
                nearLimitArtikls.add(artikl);
            }
            else if (artikl.getGornjaGranica()!=null && artikl.getUkupnaKolicina()>0.9*artikl.getGornjaGranica()){
                nearLimitArtikls.add(artikl);
            }
        }
        return nearLimitArtikls;
    }

}

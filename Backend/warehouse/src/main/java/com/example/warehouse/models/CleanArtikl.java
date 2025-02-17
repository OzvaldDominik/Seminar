package com.example.warehouse.models;

import com.example.warehouse.entities.Artikl;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CleanArtikl implements Comparable<CleanArtikl> {
    private Long idArtikl;
    private String imeArtikl;
    private Integer gornjaGranica;
    private Integer donjaGranica;
    private String opisArtikl;

    private Integer ukupnaKolicina;

    public CleanArtikl (Artikl artikl, Integer ukupnaKolicina){
        this.idArtikl = artikl.getIdArtikl();
        this.imeArtikl = artikl.getImeArtikl();
        this.gornjaGranica = artikl.getGornjaGranica();
        this.donjaGranica = artikl.getDonjaGranica();
        this.opisArtikl = artikl.getOpisArtikl();
        this.ukupnaKolicina=ukupnaKolicina;

    }
    @JsonCreator
    public CleanArtikl(@JsonProperty("idArtikl") Long idArtikl,
                       @JsonProperty("imeArtikl") String imeArtikl,
                       @JsonProperty("gornjaGranica") Integer gornjaGranica,
                       @JsonProperty("donjaGranica") Integer donjaGranica,
                       @JsonProperty("opisArtikl") String opisArtikl,
                       @JsonProperty("ukupnaKolicina") Integer ukupnaKolicina) {
        this.idArtikl = idArtikl;
        this.imeArtikl = imeArtikl;
        this.gornjaGranica = gornjaGranica;
        this.donjaGranica = donjaGranica;
        this.opisArtikl = opisArtikl;
        this.ukupnaKolicina = ukupnaKolicina;
    }

    public Long getIdArtikl() {
        return idArtikl;
    }

    public void setIdArtikl(Long idArtikl) {
        this.idArtikl = idArtikl;
    }

    public String getImeArtikl() {
        return imeArtikl;
    }

    public void setImeArtikl(String imeArtikl) {
        this.imeArtikl = imeArtikl;
    }

    public Integer getGornjaGranica() {
        return gornjaGranica;
    }

    public void setGornjaGranica(Integer gornjaGranica) {
        this.gornjaGranica = gornjaGranica;
    }

    public Integer getDonjaGranica() {
        return donjaGranica;
    }

    public void setDonjaGranica(Integer donjaGranica) {
        this.donjaGranica = donjaGranica;
    }

    public String getOpisArtikl() {
        return opisArtikl;
    }

    public void setOpisArtikl(String opisArtikl) {
        this.opisArtikl = opisArtikl;
    }

    public Integer getUkupnaKolicina() {
        return ukupnaKolicina;
    }

    public void setUkupnaKolicina(Integer ukupnaKolicina) {
        this.ukupnaKolicina = ukupnaKolicina;
    }

    @Override
    public int compareTo(CleanArtikl o) {
        return Long.compare(this.idArtikl,o.getIdArtikl());
    }
}

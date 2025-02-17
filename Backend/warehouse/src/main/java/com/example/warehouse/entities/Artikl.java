package com.example.warehouse.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="artikl")
public class Artikl {

    @Id
    @Column(name = "idArtikl")
    private Long idArtikl;

    @Column(name="imeArtikl")
    private String imeArtikl;

    @Column(name = "gornjaGranica")
    private Integer gornjaGranica;

    @Column(name = "donjaGranica_")
    private Integer donjaGranica;

    @Column(name = "opisArtikl")
    private String opisArtikl;

    @OneToMany(mappedBy = "artikl")
    private List<MogucePakirtanje> mogucePakirtanje;

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

    @Override
    public String toString() {
        return "Artikl{" +
                "idArtikl=" + idArtikl +
                ", imeArtikl='" + imeArtikl + '\'' +
                ", gornjaGranica=" + gornjaGranica +
                ", donjaGranica=" + donjaGranica +
                ", opisArtikl='" + opisArtikl + '\'' +
                '}';
    }
}

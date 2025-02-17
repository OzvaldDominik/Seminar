package com.example.warehouse.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "skladistar")
public class Skladistar {

    @Id
    @Column(name = "idSkladistar")
    private Long idSkladistar;

    @Column(name = "korsnisckoImeSkladistar", unique = true)
    private String korisnickoImeSkladistar;

    @Column(name = "imeSkladistar_")
    private String imeSkladistar;

    @Column(name = "lozinkaSkladistar")
    private String lozinkaSkladistar;

    @Column(name = "prezimeSkladistar")
    private String prezimeSkladistar;
    @ManyToMany(mappedBy = "skladistar")
    private List<Skladiste> skladiste;

    @OneToMany(mappedBy = "skladistar")
    private List<Dokument> dokument;

    public Long getIdSkladistar() {
        return idSkladistar;
    }

    public void setIdSkladistar(Long idSkladistar) {
        this.idSkladistar = idSkladistar;
    }

    public String getKorisnickoImeSkladistar() {
        return korisnickoImeSkladistar;
    }

    public void setKorisnickoImeSkladistar(String korisnickoImeSkladistar) {
        this.korisnickoImeSkladistar = korisnickoImeSkladistar;
    }

    public String getImeSkladistar() {
        return imeSkladistar;
    }

    public void setImeSkladistar(String imeSkladistar) {
        this.imeSkladistar = imeSkladistar;
    }

    public String getLozinkaSkladistar() {
        return lozinkaSkladistar;
    }

    public void setLozinkaSkladistar(String lozinkaSkladistar) {
        this.lozinkaSkladistar = lozinkaSkladistar;
    }

    public String getPrezimeSkladistar() {
        return prezimeSkladistar;
    }

    public void setPrezimeSkladistar(String prezimeSkladistar) {
        this.prezimeSkladistar = prezimeSkladistar;
    }

    @Override
    public String toString() {
        return "Skladistar{" +
                "idSkladistar=" + idSkladistar +
                ", korisnickoImeSkladistar='" + korisnickoImeSkladistar + '\'' +
                ", imeSkladistar='" + imeSkladistar + '\'' +
                ", lozinkaSkladistar='" + lozinkaSkladistar + '\'' +
                ", prezimeSkladistar='" + prezimeSkladistar + '\'' +
                '}';
    }
}
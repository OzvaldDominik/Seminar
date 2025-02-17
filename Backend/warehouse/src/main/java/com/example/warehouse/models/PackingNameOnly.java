package com.example.warehouse.models;

import com.example.warehouse.entities.MogucePakirtanje;

public class PackingNameOnly {
    private Long idMogucePakiranje;
    private String imeMogucePakiranje;

    public PackingNameOnly(MogucePakirtanje mogucePakirtanje) {
        this.idMogucePakiranje=mogucePakirtanje.getIdMogucePakiranje();
        this.imeMogucePakiranje=mogucePakirtanje.getImeMogucePakiranje();
    }

    public PackingNameOnly(Long idMogucePakiranje, String imeMogucePakiranje) {
        this.idMogucePakiranje = idMogucePakiranje;
        this.imeMogucePakiranje = imeMogucePakiranje;
    }

    public Long getIdMogucePakiranje() {
        return idMogucePakiranje;
    }

    public void setIdMogucePakiranje(Long idMogucePakiranje) {
        this.idMogucePakiranje = idMogucePakiranje;
    }

    public String getImeMogucePakiranje() {
        return imeMogucePakiranje;
    }

    public void setImeMogucePakiranje(String imeMogucePakiranje) {
        this.imeMogucePakiranje = imeMogucePakiranje;
    }
}

package com.sinaukoding.tugashari3.tugashari3.controller;

public class MapelDto {
    private Integer id;
    private String nama;
    private String deskripsi;
    //private String nip;
    //private String nomorHp;
    //private String alamat;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public String getDeskripsi() {
     return deskripsi;
    }
    //public String getNip() {
    //  return nip;
    //}
    //public String getNomorHp() {
    //  return nomorHp;
    // }
    //public String getAlamat() {
    //   return alamat;
    //}
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setDeskripsi(String deskripsi) {
     this.deskripsi = deskripsi;
    }
    //public void setNip(String nip) {
    //  this.nip = nip;
    // }
    //public void setNomorHp(String nomorHp) {
    //  this.nomorHp = nomorHp;
    //}
    //public void setAlamat(String alamat) {
    //  this.alamat = alamat;
    //}
}

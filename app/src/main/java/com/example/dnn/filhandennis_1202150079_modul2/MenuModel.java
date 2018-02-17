package com.example.dnn.filhandennis_1202150079_modul2;

/**
 * Created by ASUS on 17/02/2018.
 */

public class MenuModel {
    private String nama;
    private int harga;
    private int gambar;
    private String deskripsi;

    public MenuModel(String nama, int harga, int gambar, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

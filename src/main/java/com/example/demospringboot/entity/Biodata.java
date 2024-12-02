package com.example.demospringboot.entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;

@MappedSuperclass
public abstract class Biodata {

    @Column(name = "nama", nullable = false)
    protected String nama;

    @Column(name = "alamat")
    protected String alamat;

    @Column(name = "no_telp")
    protected String no_telp;

    // No-argument constructor (diperlukan oleh Hibernate)
    public Biodata() {
        // Hibernate akan mengatur default secara otomatis
    }

    // Parameterized constructor
    public Biodata(String nama, String alamat, String no_telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public abstract void Notifikasi();
}


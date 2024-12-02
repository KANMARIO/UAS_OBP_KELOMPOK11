package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dokter")
public class Dokter extends Biodata{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "spesialis")
    private String spesialis;

    // Default constructor (required by JPA)
    public Dokter() {
        super();
    }

    // Constructor for adding a new doctor
    public Dokter(String nama, String alamat, String no_telp, String spesialis) {
        super(nama, alamat, no_telp);
        this.spesialis = spesialis;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    // Optional: toString, equals, and hashCode methods can be useful for debugging and logging
    @Override
    public String toString() {
        return "Dokter{" +
                "id=" + id +
                ", dokter_nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", no_telp='" + no_telp + '\'' +
                ", spesialis='" + spesialis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dokter dokter = (Dokter) o;
        return id == dokter.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public void Notifikasi() {
        System.out.println("Dokter Berhasil di inputkan");
    }

}

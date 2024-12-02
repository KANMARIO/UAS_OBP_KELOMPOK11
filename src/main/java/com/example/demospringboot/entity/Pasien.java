package com.example.demospringboot.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "pasien")
public class Pasien extends Biodata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use database auto-increment
    @Column(name = "pasien_id")
    private int pasien_id;

    @Column(name = "password", nullable = false)
    private String password;

    // Default constructor (required by Hibernate)
    public Pasien() {
        super(); // Calls the no-argument constructor of Biodata
    }

    // Parameterized constructor
    public Pasien(String nama, String alamat, String no_telp, String password) {
        super(nama, alamat, no_telp);
        this.password = password;
    }

    // Getters and Setters
    public int getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(int pasien_id) {
        this.pasien_id = pasien_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void Notifikasi() {
        System.out.println("Pasien Berhasil di inputkan");
    }

}

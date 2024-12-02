package com.example.demospringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name = "rawat")
@IdClass(RawatId.class)  // Use the RawatId class as the IdClass
public class Rawat{

    @Id
    @Column(name = "rawat_id")
    private Integer rawat_id;

    @Id
    @Column(name = "pasien_id")
    private Integer pasien_id;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "rekam_medis")
    private String rekam_medis;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal")
    private LocalDate tanggal;

    // Default constructor
    public Rawat() {}

    // Constructor with fields
    public Rawat(Integer rawat_id, Integer pasien_id, Integer id, String rekam_medis, LocalDate tanggal) {
        this.rawat_id = rawat_id;
        this.pasien_id = pasien_id;
        this.id = id;
        this.rekam_medis = rekam_medis;
        this.tanggal = tanggal;
    }

    // Getters and Setters
    public Integer getRawat_id() {
        return rawat_id;
    }

    public void setRawat_id(Integer rawat_id) {
        this.rawat_id = rawat_id;
    }

    public Integer getPasien_id() {
        return pasien_id;
    }

    public void setPasien_id(Integer pasien_id) {
        this.pasien_id = pasien_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRekam_medis() {
        return rekam_medis;
    }

    public void setRekam_medis(String rekam_medis) {
        this.rekam_medis = rekam_medis;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Rawat{" +
                "rawat_id=" + rawat_id +
                ", pasien_id=" + pasien_id +
                ", id=" + id +
                ", rekam_medis='" + rekam_medis + '\'' +
                ", tanggal=" + tanggal +
                '}';
    }

    public void setRawatPK(RawatId rawatId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRawatPK'");
    }
}

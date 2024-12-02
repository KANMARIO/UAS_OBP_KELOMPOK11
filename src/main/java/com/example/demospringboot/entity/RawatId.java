package com.example.demospringboot.entity;

import java.io.Serializable;
import java.util.Objects;

public class RawatId implements Serializable {

    private Integer rawat_id;
    private Integer pasien_id;
    private Integer id;

    // Default constructor
    public RawatId() {}

    // Constructor with fields
    public RawatId(Integer rawat_id, Integer pasien_id, Integer id) {
        this.rawat_id = rawat_id;
        this.pasien_id = pasien_id;
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawatId rawatId = (RawatId) o;
        return rawat_id.equals(rawatId.rawat_id) && pasien_id.equals(rawatId.pasien_id) && id.equals(rawatId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawat_id, pasien_id, id);
    }
}

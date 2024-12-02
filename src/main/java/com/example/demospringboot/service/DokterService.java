package com.example.demospringboot.service;

import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.repository.DokterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DokterService {

    @Autowired
    private DokterRepository dokterRepository;

    // Retrieve all doctors
    public List<Dokter> getAllDok() {
        return dokterRepository.findAll(); // Consider pagination if needed in the future
    }

    // Retrieve a specific doctor by ID
    public Dokter getDokById(int id) {
        Optional<Dokter> dokter = dokterRepository.findById(id);
        return dokter.orElseThrow(() -> new IllegalArgumentException("Doctor not found with id " + id));
    }

    // Add a new doctor
    public Dokter addDok(Dokter dok) {
        return dokterRepository.save(dok);
    }

    // Update an existing doctor
    public Dokter updateDok(int id, Dokter dok) {
        // Check if the doctor exists before updating
        if (!dokterRepository.existsById(id)) {
            throw new IllegalArgumentException("Doctor not found with id " + id);
        }
        dok.setId(id);
        return dokterRepository.save(dok);
    }

    @Transactional
    public void deleteDok(int id) {
        if (dokterRepository.existsById(id)) {
            try {
                dokterRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Gagal menghapus dokter dengan id " + id, e);
            }
        } else {
            throw new IllegalArgumentException("Doctor not found with id " + id);
        }
    }
    
}

package com.example.demospringboot.service;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.repository.PasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PasienService {

    @Autowired
    private PasienRepository pasienRepository;

    // Retrieve all pasiens
    public List<Pasien> getAllpas() {
        return pasienRepository.findAll(); // Consider pagination if needed in the future
    }

    // Retrieve a specific pasien by ID
    public Pasien getpasById(int pasien_id) {
        Optional<Pasien> pasien = pasienRepository.findById(pasien_id);
        return pasien.orElseThrow(() -> new IllegalArgumentException("pasien not found with id " + pasien_id));
    }

    // Login
    public Pasien authenticatePasienById(int pasienId, String password) {
        Optional<Pasien> pasienOptional = pasienRepository.findById(pasienId);
        if (pasienOptional.isPresent()) {
            Pasien pasien = pasienOptional.get();
            if (pasien.getPassword().equals(password)) {
                return pasien; // User authenticated
            }
        }
        return null; // Authentication failed
    }

    // Add a new pasien
    public Pasien addpas(Pasien pas) {
        return pasienRepository.save(pas);
    }

    // Update an existing pasien
    public Pasien updatepas(int pasien_id, Pasien pas) {
        // Check if the pasien exists before updating
        if (!pasienRepository.existsById(pasien_id)) {
            throw new IllegalArgumentException("pasien not found with id " + pasien_id);
        }
        pas.setPasien_id(pasien_id);
        return pasienRepository.save(pas);
    }

    // Delete a pasien by ID
    @Transactional
    public void deletepas(int pasien_id) {
        try {
            pasienRepository.deleteById(pasien_id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("pasien not found with id " + pasien_id);
        }
    }
}

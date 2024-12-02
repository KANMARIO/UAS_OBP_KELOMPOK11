package com.example.demospringboot.service;

import com.example.demospringboot.entity.Rawat;
import com.example.demospringboot.entity.RawatId;
import com.example.demospringboot.repository.RawatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RawatService {

    @Autowired
    private RawatRepository rawatRepository;

    // Retrieve all rawats
    public List<Rawat> getAllraw() {
        return rawatRepository.findAll(); // Consider pagination if needed in the future
    }

    // Retrieve a specific rawat by composite ID
    public Rawat getrawById(RawatId rawatId) {
        Optional<Rawat> rawat = rawatRepository.findById(rawatId);
        return rawat.orElseThrow(() -> new IllegalArgumentException("Rawat not found with ID " + rawatId));
    }

    // Add a new rawat
    public Rawat addraw(Rawat rawat) {
        return rawatRepository.save(rawat);
    }

    // Update an existing rawat by composite ID
    public Rawat updateraw(RawatId rawatId, Rawat rawat) {
        // Check if the rawat exists before updating
        if (!rawatRepository.existsById(rawatId)) {
            throw new IllegalArgumentException("Rawat not found with ID " + rawatId);
        }
        rawat.setRawatPK(rawatId); // Ensure that the composite key is set in the updated entity
        return rawatRepository.save(rawat);
    }

    // Delete a rawat by composite ID
    @Transactional
    public void deleteraw(RawatId rawatId) {
        try {
            rawatRepository.deleteById(rawatId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Rawat not found with ID " + rawatId);
        }
    }
}

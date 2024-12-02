package com.example.demospringboot.repository;
import com.example.demospringboot.entity.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
// Interface
public interface PasienRepository
extends JpaRepository<Pasien, Integer> {
}


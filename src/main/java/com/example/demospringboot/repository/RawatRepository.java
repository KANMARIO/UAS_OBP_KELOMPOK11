package com.example.demospringboot.repository;
import com.example.demospringboot.entity.Rawat;
import com.example.demospringboot.entity.RawatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawatRepository extends JpaRepository<Rawat, RawatId> {
    // Custom query methods can be defined here
}

package com.example.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ormlearn.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
    // Custom method to search countries by partial name (case-insensitive)
    List<Country> findByCoNameContainingIgnoreCase(String partialName);
}

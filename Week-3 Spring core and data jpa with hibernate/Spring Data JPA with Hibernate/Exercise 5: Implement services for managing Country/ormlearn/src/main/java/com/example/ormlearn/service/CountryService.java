package com.example.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ormlearn.entity.Country;
import com.example.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findByCode(String code) {
        Optional<Country> country = countryRepository.findById(code);
        return country.orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, Country updatedCountry) {
        if (countryRepository.existsById(code)) {
            updatedCountry.setCoCode(code); // ensure same primary key
            return countryRepository.save(updatedCountry);
        }
        return null;
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchByName(String partialName) {
        return countryRepository.findByCoNameContainingIgnoreCase(partialName);
    }
}

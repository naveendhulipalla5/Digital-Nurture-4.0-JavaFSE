package com.example.ormlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.ormlearn.entity.Country;
import com.example.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/{code}")
    public ResponseEntity<?> getByCode(@PathVariable String code) {
        try {
            Country country = service.findCountryByCode(code);
            return ResponseEntity.ok(country);
        } catch (CountryNotFoundException e) {
            return ResponseEntity.status(404).body("Country not found with code: " + code);
        }
    }


    @PostMapping
    public Country add(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country update(@PathVariable String code, @RequestBody Country updatedCountry) {
        return service.updateCountry(code, updatedCountry);
    }

    @DeleteMapping("/{code}")
    public String delete(@PathVariable String code) {
        service.deleteCountry(code);
        return "Country with code " + code + " deleted successfully.";
    }


    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}

package com.example.ormlearn;

import com.example.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import com.example.ormlearn.entity.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OrmlearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(OrmlearnApplication.class, args);
	}

	@PostConstruct
	public void testFindCountryByCode() {
		LOGGER.info("Start");

		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}

		LOGGER.info("End");
	}
	private void testAddCountry() {
	    LOGGER.info("Start");

	    Country newCountry = new Country();
	    newCountry.setCoCode("XY");
	    newCountry.setCoName("Xylophone Land");

	    countryService.addCountry(newCountry);

	    try {
	        Country retrievedCountry = countryService.findCountryByCode("XY");
	        LOGGER.debug("Added Country: {}", retrievedCountry);
	    } catch (CountryNotFoundException e) {
	        LOGGER.error("Country not found after adding: {}", e.getMessage());
	    }

	    LOGGER.info("End");
	}
	@PostConstruct
	public void runAllTests() {
	    testAddCountry(); // add this line
	}


}

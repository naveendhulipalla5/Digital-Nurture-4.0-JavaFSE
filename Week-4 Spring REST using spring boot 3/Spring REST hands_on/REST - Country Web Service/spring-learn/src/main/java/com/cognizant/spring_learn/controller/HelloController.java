package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country; // ✅ correct model
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START");
        return "Hello World!!";
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = (Country) context.getBean("country");
        LOGGER.info("END");
        return country;
    }
}

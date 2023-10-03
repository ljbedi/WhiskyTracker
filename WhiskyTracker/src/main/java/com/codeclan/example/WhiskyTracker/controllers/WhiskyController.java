package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public List<Whisky> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distillery", required = false) String distilleryName,
            @RequestParam(name = "region", required = false) String region) {
       if (year != null) {
            return whiskyRepository.findByYear(year);
        } else if (age != null && distilleryName != null) {
            return whiskyRepository.findByAgeAndDistilleryName(age, distilleryName);
        } else if (region != null) {
            return whiskyRepository.findByDistilleryRegion(region);
        } else {
            return whiskyRepository.findAll();
       }
    }






}

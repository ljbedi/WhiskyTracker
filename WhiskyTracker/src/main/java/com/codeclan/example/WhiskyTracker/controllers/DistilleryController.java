package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value="/distilleries")
    public List<Distillery> getDistilleriesByRegion (
            @RequestParam(name="region", required=false) String region,
            @RequestParam(name="age", required=false) Integer age) {
        if (region == null && age == null) {
            return distilleryRepository.findAll();
        } else if (age != null && region == null) {
            return distilleryRepository.findByWhiskiesAge(age);
        }
        else {
            return distilleryRepository.findByRegion(region);
        }
    }

}

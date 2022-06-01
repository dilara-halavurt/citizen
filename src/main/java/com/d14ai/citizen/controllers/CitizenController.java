package com.d14ai.citizen.controllers;

import com.d14ai.citizen.exception.ErrorResponse;
import com.d14ai.citizen.models.dto.CitizenDTO;
import com.d14ai.citizen.models.entity.Citizen;
import com.d14ai.citizen.payload.request.CreateCitizenRequest;
import com.d14ai.citizen.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/citizen")
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        return ResponseEntity.ok(citizenService.getAllCitizens());
    }
    @PostMapping
    public void createCitizen(@RequestBody CreateCitizenRequest createCitizenRequest) throws ErrorResponse {
           citizenService.createCitizen(createCitizenRequest);
    }

}

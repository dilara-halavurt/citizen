package com.d14ai.citizen.controllers;

import com.d14ai.citizen.exception.ErrorResponse;
import com.d14ai.citizen.models.dto.CitizenDTO;
import com.d14ai.citizen.models.entity.Citizen;
import com.d14ai.citizen.payload.request.CreateCitizenRequest;
import com.d14ai.citizen.payload.request.UpdateCitizenRequest;
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
    @GetMapping(value = "/isCitizen")
    public ResponseEntity<List<Citizen>> getAllIsCitizenTrue() {
        return ResponseEntity.ok(citizenService.getAllIsCitizenTrue());
    }
    @GetMapping(value = "/hasDriversLiscense")
    public ResponseEntity<List<Citizen>> getAllHasDriversLiscense() {
        return ResponseEntity.ok(citizenService.getAllHasDriversLicense());
    }
    @GetMapping(value = "/byName/{name}")
    public ResponseEntity<List<Citizen>> findCitizenByNameLike(@PathVariable final String name) {
        return ResponseEntity.ok(citizenService.findCitizenByNameLike(name));
    }

    @GetMapping(value = "/numberOfChildren/{numberOfChildren}")
    public ResponseEntity<List<Citizen>> getAllWithNumberOfChildren(@PathVariable final Integer numberOfChildren) {
        return ResponseEntity.ok(citizenService.getAllWithNumberOfChildren(numberOfChildren));
    }

    @GetMapping(value = "/byId/{id}")
    public ResponseEntity<Citizen> getById(@PathVariable final Integer id) {
        return ResponseEntity.ok(citizenService.getById(id));
    }
    @PatchMapping(value = "/update")
    public void updateCitizen(@RequestBody UpdateCitizenRequest updateCitizenRequest) throws ErrorResponse {
        citizenService.updateCitizen(updateCitizenRequest);
    }

}

package com.d14ai.citizen.service;

import com.d14ai.citizen.exception.ErrorResponse;
import com.d14ai.citizen.exception.NoSuchCitizenExistsException;
import com.d14ai.citizen.models.dto.ChildrenDTO;
import com.d14ai.citizen.models.entity.Citizen;
import com.d14ai.citizen.payload.request.CreateCitizenRequest;
import com.d14ai.citizen.payload.request.UpdateCitizenRequest;
import com.d14ai.citizen.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Citizen> getAllIsCitizenTrue() {
        List<Citizen> citizenList = citizenRepository.findAllIsCitizenTrue();

        return citizenList;
    }
    public List<Citizen> getAllHasDriversLicense() {
        List<Citizen> citizenList = citizenRepository.findAllHasDriversLicense();

        return citizenList;
    }


    public List<Citizen> getAllWithNumberOfChildren(Integer numberOfChildren) {
        List<Citizen> citizenList = citizenRepository.findAllWithNumberOfChildren(numberOfChildren);

        return citizenList;
    }

    public List<Citizen> getAllCitizens() {
        List<Citizen> citizenList = citizenRepository.findAll();

        return citizenList;
    }
    public Citizen getById(Integer id) {
        Citizen citizen = id != null ? citizenRepository.findById(id)
                .orElseThrow(RuntimeException::new): new Citizen();
        return citizen;
    }

    public void createCitizen(CreateCitizenRequest createCitizenRequest) throws ErrorResponse {
        List<ChildrenDTO> childrenDTO = createCitizenRequest.getChildren();
        Citizen newCitizen = new Citizen();
        newCitizen.setName(createCitizenRequest.getName());
        newCitizen.setHasDrivingLicense(createCitizenRequest.getHasDrivingLicense());
        newCitizen.setIsCitizen(createCitizenRequest.getIsCitizen());
        HashMap<String, Integer> newCitizenChildren = new HashMap<String, Integer>();
        if( !childrenDTO.isEmpty()) {
            for (ChildrenDTO childDTO : childrenDTO) {
                if (!citizenRepository.findById(childDTO.getChildId()).isEmpty()) {
                    newCitizenChildren.put(childDTO.getName(), childDTO.getChildId());
                } else throw new NoSuchCitizenExistsException("No child with this ID exists.");

            }
        }
        newCitizen.setChildren(newCitizenChildren);
        citizenRepository.save(newCitizen);
        }

    public void updateCitizen(UpdateCitizenRequest updateCitizenRequest) throws ErrorResponse {
        Integer id = updateCitizenRequest.getId();
        Citizen citizen = id != null ? citizenRepository.findById(id)
                .orElseThrow(RuntimeException::new): new Citizen();
        List<ChildrenDTO> childrenDTO = updateCitizenRequest.getChildren();
        HashMap<String, Integer> newCitizenChildren = new HashMap<String, Integer>();
        if( !childrenDTO.isEmpty()) {
            for (ChildrenDTO childDTO : childrenDTO) {
                if (citizenRepository.findById(childDTO.getChildId()) != null) {
                    newCitizenChildren.put(childDTO.getName(), childDTO.getChildId());
                }
            }
        }
        citizen.setChildren(newCitizenChildren);
        citizen.setIsCitizen(updateCitizenRequest.getIsCitizen());
        citizen.setHasDrivingLicense(updateCitizenRequest.getHasDrivingLicense());
        citizen.setName(updateCitizenRequest.getName());


        citizenRepository.save(citizen);
    }





}

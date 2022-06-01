package com.d14ai.citizen.service;

import com.d14ai.citizen.exception.ErrorResponse;
import com.d14ai.citizen.models.dto.ChildrenDTO;
import com.d14ai.citizen.models.entity.Citizen;
import com.d14ai.citizen.payload.request.CreateCitizenRequest;
import com.d14ai.citizen.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Citizen> getAllCitizens() {
        List<Citizen> citizenList = citizenRepository.findAll();

        return citizenList;
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
                if (citizenRepository.findById(childDTO.getChildId()) != null) {
                    newCitizenChildren.put(childDTO.getName(), childDTO.getChildId());
                } else throw new ErrorResponse("This child is not a citizen!");
            }
        }
        newCitizen.setChildren(newCitizenChildren);
        citizenRepository.save(newCitizen);
        }



}

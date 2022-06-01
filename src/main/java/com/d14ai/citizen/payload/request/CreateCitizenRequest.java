package com.d14ai.citizen.payload.request;

import com.d14ai.citizen.models.dto.ChildrenDTO;

import javax.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCitizenRequest {
    @NotBlank
    private String name;
    @NotBlank
    private boolean isCitizen;
    @NotBlank
    private boolean hasDrivingLicense;
    @NotBlank
    private List<ChildrenDTO> children;

    public String getName(){ return name;}
    public boolean getIsCitizen(){ return isCitizen;}
    public boolean getHasDrivingLicense(){ return hasDrivingLicense;}
    public List<ChildrenDTO> getChildren(){return children;}

}
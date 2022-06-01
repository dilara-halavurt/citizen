package com.d14ai.citizen.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CitizenDTO {

    private Integer id;
    private String name;
    private boolean isCitizen;
    private boolean hasDrivingLicense;
    private Map<String, Integer> children;

    public Integer getId(){ return id;}
    public String getName(){ return name;}
    public boolean getIsCitizen(){ return isCitizen;}
    public boolean getHasDrivingLicense(){ return hasDrivingLicense;}
    public Map<String, Integer> getChildren(){return children;}
}

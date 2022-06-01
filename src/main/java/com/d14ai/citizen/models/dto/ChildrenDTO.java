package com.d14ai.citizen.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildrenDTO {

    private Integer childId;
    private String name;


    public Integer getChildId(){ return childId;}
    public String getName(){ return name;}

}

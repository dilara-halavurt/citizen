package com.d14ai.citizen.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_citizen")
    private boolean isCitizen;

    @Column(name = "has_driving_license")
    private boolean hasDrivingLicense;

    @ElementCollection
    @CollectionTable(name = "children_mapping",
            joinColumns = {@JoinColumn(name = "citizen_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "child_name")
    @Column(name = "child_id")
    private Map<String, Integer> children;

    public Integer getId(){ return id;}
    public String getName(){ return name;}
    public Map<String, Integer> getChildren(){return children;}
    public boolean getIsCitizen(){ return isCitizen;}
    public boolean getHasDrivingLicense(){ return hasDrivingLicense;}
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setChildren(HashMap<String, Integer> children){
        this.children = children;
    }
    public void setIsCitizen(Boolean isCitizen){
        this.isCitizen = isCitizen;
    }
    public void setHasDrivingLicense(Boolean hasDrivingLicense){
        this.hasDrivingLicense = hasDrivingLicense;
    }

}

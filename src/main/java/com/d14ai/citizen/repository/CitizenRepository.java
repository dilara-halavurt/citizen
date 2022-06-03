package com.d14ai.citizen.repository;

import com.d14ai.citizen.models.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    @Query("SELECT c FROM Citizen c WHERE c.name like '%:name%'")
    List<Citizen> findCitizenByNameLike(@Param("name") String name);
    @Query("SELECT c FROM Citizen c WHERE c.isCitizen = true")
    List<Citizen> findAllIsCitizenTrue();
    @Query("SELECT c FROM Citizen c WHERE c.hasDrivingLicense = true")
    List<Citizen> findAllHasDriversLicense();
    @Query("SELECT c FROM Citizen c WHERE c.children.size = :numberOfChildren")
    List<Citizen> findAllWithNumberOfChildren(@Param("numberOfChildren") Integer numberOfChildren);
}


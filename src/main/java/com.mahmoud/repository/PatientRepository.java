package com.mahmoud.repository;

import com.mahmoud.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(Long id);

    Optional<Patient> findByFirstName(String firstName);

    Optional<Patient> findByMobilePhone(String mobile);

    Optional<Patient> findByPatientProfileKey(String key);

}

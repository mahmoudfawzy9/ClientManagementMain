package com.mahmoud.service;

import com.mahmoud.entity.Patient;
import com.mahmoud.mapper.PatientProfileMapper;
import com.mahmoud.repository.PatientRepository;
import com.mahmoud.request.CreatePatientProfileRequest;
import com.mahmoud.response.CreatePatientResponse;
import com.mahmoud.utils.SharedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService {
        @Autowired
        PatientRepository patientRepository;

        @Autowired
    PatientProfileMapper patientProfileMapper;
@Override
    public ResponseEntity<CreatePatientResponse> insert(
            CreatePatientProfileRequest createPatientProfileRequest
    ){

        Optional<Patient> findByFirstName = patientRepository
                .findByFirstName(createPatientProfileRequest.getFirstName());

    Optional<Patient> findByPatientProfileKey = patientRepository
            .findByPatientProfileKey(createPatientProfileRequest.getPatientProfileKey());
    Optional<Patient> findByMobilePhone = patientRepository
            .findByFirstName(createPatientProfileRequest.getMobilePhone());

    //This means I cannot add a patient twice identified by his Patient Profile Key
        if (findByFirstName.isPresent()
                && findByPatientProfileKey.get().getPatientProfileKey().equalsIgnoreCase(createPatientProfileRequest.getPatientProfileKey()))
            throw new RuntimeException();

        Patient profileDtoToEntity = patientProfileMapper.mapPatientRequestToEntity(createPatientProfileRequest);

        Patient patientProfile = patientRepository.save(profileDtoToEntity);

        patientProfile.setPpsNumber(SharedUtils.generateCode("PPS", patientProfile.getId()));
        patientProfile.setPatientProfileKey(SharedUtils.generateCode("PPK", patientProfile.getId()));
        patientProfile.setHomePhone(createPatientProfileRequest.getHomePhone());
        patientProfile.setGender(createPatientProfileRequest.getGender());
        patientRepository.save(profileDtoToEntity);

        return new ResponseEntity<>(CreatePatientResponse.builder().message("Data Saved").messageCode(201)
                .patientId(patientProfile.getId()).build(), HttpStatus.CREATED);
    }

}
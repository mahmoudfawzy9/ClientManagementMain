package com.mahmoud.mapper;

import com.mahmoud.entity.Patient;
import com.mahmoud.request.CreatePatientProfileRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PatientProfileMapper {

    public Patient mapPatientRequestToEntity(CreatePatientProfileRequest createPatientProfileRequest) {
        Patient patientProfile = Patient.builder().firstName(createPatientProfileRequest.getFirstName())
                .lastName(createPatientProfileRequest.getLastName())
                .middleName(createPatientProfileRequest.getMiddleName())
                .email(createPatientProfileRequest.getEmail())
                .mobilePhone(createPatientProfileRequest.getMobilePhone())
                .ppsNumber(createPatientProfileRequest.getPpsNumber())
                .dateOfBirth(createPatientProfileRequest.getDateOfBirth())
                .build();

        return patientProfile;
    }
}

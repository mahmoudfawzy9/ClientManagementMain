package com.mahmoud.service;

import com.mahmoud.entity.Patient;
import com.mahmoud.request.CreatePatientProfileRequest;
import com.mahmoud.response.CreatePatientResponse;
import org.springframework.http.ResponseEntity;

public interface PatientService {

    ResponseEntity<CreatePatientResponse> insert(CreatePatientProfileRequest createPatientProfileRequest);
}

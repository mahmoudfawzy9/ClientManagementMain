package com.mahmoud.service;

import com.mahmoud.entity.Patient;
import com.mahmoud.mapper.PatientRegisterScreenOneDto;
import com.mahmoud.request.CreatePatientProfileRequest;
import com.mahmoud.response.CreatePatientResponse;
import com.mahmoud.response.SuccessResponse;
import org.springframework.http.ResponseEntity;

public interface PatientService {

    ResponseEntity<CreatePatientResponse> create(CreatePatientProfileRequest createPatientProfileRequest);

    Patient getPatientById(Long id);

    SuccessResponse<Patient> delete(Long id);

    SuccessResponse<Patient> update(Long id, PatientRegisterScreenOneDto dto);}

package com.mahmoud.controller;

import com.mahmoud.request.CreatePatientProfileRequest;
import com.mahmoud.response.CreatePatientResponse;
import com.mahmoud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientProfileService;
    @PostMapping(value = "/create")
    public ResponseEntity<CreatePatientResponse> createPriceProfile(
             @RequestBody CreatePatientProfileRequest createPatientProfileRequest) {
        return patientProfileService.insert(createPatientProfileRequest);
    }
}

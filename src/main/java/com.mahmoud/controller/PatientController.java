package com.mahmoud.controller;

import com.mahmoud.entity.Patient;
import com.mahmoud.mapper.PatientRegisterScreenOneDto;
import com.mahmoud.request.CreatePatientProfileRequest;
import com.mahmoud.response.CreatePatientResponse;
import com.mahmoud.response.SuccessResponse;
import com.mahmoud.service.PatientService;
import com.mahmoud.utils.ResponseIntegerKeys;
import com.mahmoud.utils.ResponseStringKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientProfileService;
    @PostMapping(value = "/create")
    public ResponseEntity<CreatePatientResponse> createPatientProfile(
             @RequestBody CreatePatientProfileRequest createPatientProfileRequest) {
        return patientProfileService.create(createPatientProfileRequest);
    }

    @GetMapping(path = "/{patientId}", produces = "application/json")
    public Patient getPatientById(@PathVariable Long patientId) {
        Patient patient = patientProfileService.getPatientById(patientId);
        return patientProfileService.getPatientById(patientId);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<SuccessResponse<Patient>> delete(@RequestParam("id") Long id){
        return new ResponseEntity<>(patientProfileService.delete(id), HttpStatus.OK);
    }

    @PutMapping(value = "update")
    public SuccessResponse<Patient> updatePatientProfile(
            @RequestParam("patientId") Long patientId, @RequestBody PatientRegisterScreenOneDto dto
    ){
        return new SuccessResponse<Patient>(
                ResponseStringKeys.UPDATED,
                ResponseIntegerKeys.CREATED,
                patientProfileService.update(patientId, dto).getData());

    }
}

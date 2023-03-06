package com.mahmoud.request;

import com.mahmoud.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatePatientProfileRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String patientProfileKey;

    @NotNull
    private String middleName;
    private String email;
    @NotNull
    private String mobilePhone;
    private String ppsNumber;

    private String homePhone;

    @NotNull
    private Gender gender;
    private String dateOfBirth;
    private Long patientId;

}

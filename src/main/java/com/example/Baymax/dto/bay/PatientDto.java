package com.example.Baymax.dto.bay;

import com.example.Baymax.model.Patient;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PatientDto {
    private long id;
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotNull(message = "Creation Date is required")
    private Date creationDate;

    @NotNull(message = "DOB is required")
    private Date dateOfBirth;

    @NotNull(message = "Phone Number is required")
    private String phoneNumber;

    private String email;

    public PatientDto(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.gender = patient.getGender();
        this.creationDate = new Date();
        this.dateOfBirth = patient.getDateOfBirth();
        this.phoneNumber = patient.getPhoneNumber();
        this.email = patient.getEmail();
    }

    public PatientDto(String name, String gender, Date dateOfBirth, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.creationDate = new Date();
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public PatientDto() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

package com.example.Baymax.service.bay;

import com.example.Baymax.dto.bay.PatientDto;
import com.example.Baymax.model.Patient;
import com.example.Baymax.repository.bay.IPatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientDto::new)
                .collect(Collectors.toList());
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient toPatient(PatientDto patientDto) {
        Patient patient = patientRepository.findById(patientDto.getId()).orElse(new Patient());
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setCreationDate(patientDto.getCreationDate());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setEmail(patientDto.getEmail());
        return patient;
    }

}

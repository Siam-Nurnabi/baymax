package com.example.Baymax.service.bay;

import com.example.Baymax.dto.bay.PatientDto;
import com.example.Baymax.model.bay.Patient;
import com.example.Baymax.repository.bay.IPatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDto> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return toPatientDtoList.apply(patientList);
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
        patient.setCreationDate(LocalDateTime.now());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setEmail(patientDto.getEmail());
        return patient;
    }

    Function<List<Patient>, List<PatientDto>> toPatientDtoList = patientList -> patientList.stream()
            .map(PatientDto::new)
            .collect(Collectors.toList());

}

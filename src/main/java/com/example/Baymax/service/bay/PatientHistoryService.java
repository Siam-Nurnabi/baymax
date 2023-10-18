package com.example.Baymax.service.bay;

import com.example.Baymax.model.bay.PatientHistory;
import com.example.Baymax.repository.bay.IPatientHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientHistoryService {
    private final IPatientHistoryRepository patientHistoryRepository;

    public PatientHistoryService(IPatientHistoryRepository patientHistoryRepository) {
        this.patientHistoryRepository = patientHistoryRepository;
    }

    public void createPatientHistory(PatientHistory patientHistory) {
        patientHistoryRepository.save(patientHistory);
    }

    public List<PatientHistory> getAllPatientHistory() {
        return patientHistoryRepository.findAll();
    }
}

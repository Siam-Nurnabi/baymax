package com.example.Baymax.repository.bay;

import com.example.Baymax.model.bay.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientHistoryRepository extends JpaRepository<PatientHistory, Long> {
}

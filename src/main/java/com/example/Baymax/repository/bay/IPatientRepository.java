package com.example.Baymax.repository.bay;

import com.example.Baymax.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
}

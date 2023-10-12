package com.example.Baymax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Baymax.model.Loan;

public interface IItemIssuanceRepository extends JpaRepository<Loan, Long> {

}

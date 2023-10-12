package com.example.Baymax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Baymax.model.Borrower;

public interface IBorrowerRepository extends JpaRepository<Borrower, Long> {

}

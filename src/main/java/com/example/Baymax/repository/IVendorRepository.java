package com.example.Baymax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Baymax.model.Vendor;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Long> {

}

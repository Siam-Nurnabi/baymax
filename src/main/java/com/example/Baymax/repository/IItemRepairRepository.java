package com.example.Baymax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Baymax.model.ItemRepair;

@Repository
public interface IItemRepairRepository extends JpaRepository<ItemRepair, Long> {

}

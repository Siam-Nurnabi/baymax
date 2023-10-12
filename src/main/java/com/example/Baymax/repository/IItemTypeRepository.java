package com.example.Baymax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Baymax.model.ItemType;

public interface IItemTypeRepository extends JpaRepository<ItemType, Long> {

}
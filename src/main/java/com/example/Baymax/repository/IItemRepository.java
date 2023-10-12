package com.example.Baymax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Baymax.model.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {

}

package com.example.Baymax.repository;

import com.example.Baymax.model.InventoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<InventoryUser, Long> {

    InventoryUser getInventoryUserByName(String name);
    InventoryUser getInventoryUserByEmail(String email);
}

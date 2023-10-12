package com.example.Baymax.repository;

import com.example.Baymax.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByPrivilegeName(String name);
}

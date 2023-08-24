package com.example.IMS.repository;

import com.example.IMS.model.Privilege;
import com.example.IMS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByPrivilegeName(String name);
}

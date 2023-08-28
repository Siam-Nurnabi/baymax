package com.example.IMS.service;

import com.example.IMS.enums.Permission;
import com.example.IMS.enums.RoleName;
import com.example.IMS.model.InventoryUser;
import com.example.IMS.model.Privilege;
import com.example.IMS.model.Role;
import com.example.IMS.repository.IPrivilegeRepository;
import com.example.IMS.repository.IRoleRepository;
import com.example.IMS.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
public class SetupDataLoaderService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IPrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Privilege> adminPrivileges = new ArrayList<>();
        List<Privilege> stuffPrivileges = new ArrayList<>();
        List<Privilege> userPrivileges = new ArrayList<>();

        for (Permission permission : Permission.values()) {
            Privilege privilege = createPrivilegeIfNotFound(permission);
            if (privilege.getPrivilegeName().contains("READ")) {
                adminPrivileges.add(privilege);
                stuffPrivileges.add(privilege);
                userPrivileges.add(privilege);
            } else if (privilege.getPrivilegeName().contains("WRITE")) {
                adminPrivileges.add(privilege);
                stuffPrivileges.add(privilege);
            } else if (privilege.getPrivilegeName().contains("DELETE")) {
                adminPrivileges.add(privilege);
            }
        }

        for (RoleName role : RoleName.values()) {
            List<Privilege> privileges = new ArrayList<>();
            String testUserName = "";
            if (role.getName().contains("ADMIN")) {
                privileges = adminPrivileges;
                testUserName = "admin";
            } else if (role.getName().contains("STUFF")) {
                privileges = stuffPrivileges;
                testUserName = "stuff";
            } else if (role.getName().contains("USER")) {
                privileges = userPrivileges;
                testUserName = "user";
            }
            Role db_role = createRoleIfNotFound(role.getName(), privileges);
            if (!testUserName.equals("")) {
                createUserIfNotFound(testUserName, Collections.singletonList(db_role));
            }
        }
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(Permission permission) {
        Privilege privilege = privilegeRepository.findByPrivilegeName(permission.getPrivilege());
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setPrivilegeName(permission.getPrivilege());
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, List<Privilege> privileges) {
        Role role = roleRepository.findByRoleName(name);
        if (role == null) {
            role = new Role();
            role.setRoleName(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    void createUserIfNotFound(String name, List<Role> roles) {
        InventoryUser user = userRepository.getInventoryUserByName(name);
        if (user == null) {
            user = new InventoryUser();
            user.setPassword(passwordEncoder.encode(name));
            user.setEmail("test@test.com");
            user.setName(name);
            user.setUserRoles(new HashSet<>(roles));
            userRepository.save(user);
        }
    }

}

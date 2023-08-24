package com.example.IMS.service;

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

import java.util.Arrays;
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

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        InventoryUser user = userRepository.getInventoryUserByName("Test");
        if (user != null){
            return;
        }

        Privilege readPrivilege = createPrivilegeIfNotFound("USER_READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("USER_WRITE_PRIVILEGE");
        Privilege deletePrivilege = createPrivilegeIfNotFound("USER_DELETE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege, deletePrivilege);
        List<Privilege> stuffPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        List<Privilege> userPrivileges = Collections.singletonList(readPrivilege);

        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_STUFF", stuffPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
        user = new InventoryUser();
        user.setName("test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setUserRoles(new HashSet<>(Collections.singletonList(adminRole)));
        userRepository.save(user);
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepository.findByPrivilegeName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setPrivilegeName(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    void createRoleIfNotFound(String name, List<Privilege> privileges) {
        Role role = roleRepository.findByRoleName(name);
        if (role == null) {
            role = new Role();
            role.setRoleName(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
    }

}

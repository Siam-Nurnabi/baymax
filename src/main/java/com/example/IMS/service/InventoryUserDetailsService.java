package com.example.IMS.service;

import com.example.IMS.IMSUserDetails;
import com.example.IMS.model.InventoryUser;
import com.example.IMS.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InventoryUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        InventoryUser user = userRepository.getInventoryUserByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new IMSUserDetails(user);
    }
}

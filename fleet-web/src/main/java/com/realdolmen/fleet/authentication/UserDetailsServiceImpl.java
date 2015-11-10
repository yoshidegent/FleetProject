package com.realdolmen.fleet.authentication;

import com.realdolmen.fleet.Employee;
import com.realdolmen.fleet.User;
import com.realdolmen.fleet.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException("The user with email address " + email + " was not found.");

        if(user instanceof Employee) {
            Employee employee = (Employee) user;
            if(!employee.isActive())
                throw new UsernameNotFoundException("The user is inactive.");
        }

        return new FleetPrincipal(user);
    }
}

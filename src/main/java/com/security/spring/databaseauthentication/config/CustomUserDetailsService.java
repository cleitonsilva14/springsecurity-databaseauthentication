package com.security.spring.databaseauthentication.config;

import com.security.spring.databaseauthentication.entity.Employee;
import com.security.spring.databaseauthentication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByEmail(email);
        if(employee == null){
            throw new UsernameNotFoundException("Username not found!");
        }else {
            return new CustomUser(employee);
        }

    }
}

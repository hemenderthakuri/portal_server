package com.job.portal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.job.portal.dao.UsersRepository;
import com.job.portal.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userEmail)
            throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with email : " + userEmail)
        );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Integer id) {
    	Users user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }
}
package com.sample.jwtauth.service;


import com.sample.jwtauth.entity.UserEntity;
import com.sample.jwtauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserEntity user =  userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found witrh email "+email));
        return  UserDetailsImpl.build(user);
    }
}

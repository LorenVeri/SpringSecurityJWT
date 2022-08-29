package com.example.demo.services;

import com.example.demo.entities.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IAppUserService extends IGeneralService<AppUser>,UserDetailsService  {
    Optional<AppUser> findByUsername(String username);
}

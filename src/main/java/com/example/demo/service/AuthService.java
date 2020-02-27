package com.example.demo.service;

import com.example.demo.dto.UserSignInRequest;
import com.example.demo.dto.CustomerSignUpRequest;
import com.example.demo.exception.SuchUserAlreadyExistException;
import com.example.demo.security.LoadUserDetailService;
import com.example.demo.security.SaveUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final LoadUserDetailService loadUserDetailService;
    private final SaveUserDetailService saveUserDetailService;

    public void signUp(final CustomerSignUpRequest request) throws SuchUserAlreadyExistException {
        try {
            if (loadUserDetailService.loadUserByUsername(request.getEmail()) != null) {
                throw new SuchUserAlreadyExistException("User with email=" + request.getEmail() + " already exists");
            }
        } catch (final UsernameNotFoundException e) {
            saveUserDetailService.saveUser(request.getEmail(), request.getPassword());
        }
    }

    public String signIn(final UserSignInRequest request) {
        return "{\"id\":1}";
    }
}
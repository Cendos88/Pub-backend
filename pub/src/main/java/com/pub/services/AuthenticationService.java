package com.pub.services;

import com.pub.models.*;
import com.pub.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.pub.models.Role.BARTENDER;
import static com.pub.models.Role.GUEST;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) throws PubException {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new PubException("Name is required");
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new PubException("Password is required");
        }


        if (request.getPocket() <= 0) {
            throw new PubException("You need money to drink");
        }
        var user = User.builder()
                .name(request.getName())
                .pocket(request.getPocket())
                .isActive(false)
                .isAdult(request.isAdult())
                .role(GUEST)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        if(request.getRole().equals("BARTENDER")){
            user.setRole(BARTENDER);
        }
        repository.save(user);
        var jwt = jwtTokenService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = repository.findByName(request.getName())
                .orElseThrow();

        var jwt = jwtTokenService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}

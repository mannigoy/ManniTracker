package com.Gcash.ManniTracker.service;

import com.Gcash.ManniTracker.model.User;
import com.Gcash.ManniTracker.repository.UserRepository;
import com.Gcash.ManniTracker.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    // Get or create user from Supabase JWT
    public User getOrCreateUser(String token) {
        UUID supabaseId = jwtUtil.extractUserId(token);
        String email = jwtUtil.extractEmail(token);

        // If user exists return them, otherwise create new user
        return userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setId(supabaseId);
                    newUser.setEmail(email);
                    return userRepository.save(newUser);
                });
    }

    // Get current user from token
    public User getCurrentUser(String token) {
        String email = jwtUtil.extractEmail(token);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
package com.Gcash.ManniTracker.Controller;

import com.Gcash.ManniTracker.model.User;
import com.Gcash.ManniTracker.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Called after Supabase Magic Link login
    // Creates user in our DB if first time
    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        User user = authService.getOrCreateUser(token);
        return ResponseEntity.ok(user);
    }

    // Get current logged in user
    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(
            @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        User user = authService.getCurrentUser(token);
        return ResponseEntity.ok(user);
    }
}

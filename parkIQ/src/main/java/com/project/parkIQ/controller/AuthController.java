package com.project.parkIQ.controller;

import com.project.parkIQ.Repository.UserRepository;
import com.project.parkIQ.entity.User;
import com.project.parkIQ.service.JwtService;
import com.project.parkIQ.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isEmpty()){
            return ResponseEntity.badRequest().body("User not found");
        }
        if(!user.get().getPassword().equals(request.getPassword())){
            return ResponseEntity.badRequest().body(("Invalid password"));
        }

        String token=jwtService.generateToken(request.getEmail());
        return ResponseEntity.ok(token);
    }
}

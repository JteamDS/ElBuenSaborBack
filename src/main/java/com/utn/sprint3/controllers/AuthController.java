package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.AuthResponse;
import com.utn.sprint3.Dto.DtoCliente;
import com.utn.sprint3.Dto.DtoLogin;
import com.utn.sprint3.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody DtoLogin dtoLogin)
    {
        return ResponseEntity.ok(authService.login(dtoLogin));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody DtoCliente dtoCliente)
    {
        return ResponseEntity.ok(authService.register(dtoCliente));
    }
}

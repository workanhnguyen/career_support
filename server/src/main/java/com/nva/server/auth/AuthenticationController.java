package com.nva.server.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        int response = authenticationService.register(request);
        switch (response) {
            case -1:
                return new ResponseEntity("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
            case 0:
                return new ResponseEntity("Email taken", HttpStatus.NOT_ACCEPTABLE);
            case 1:
                return new ResponseEntity("Register successfully!", HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @CrossOrigin
    @GetMapping("/confirm")
    public String confirm(@RequestParam(name = "token") String token) {
        return authenticationService.confirmToken(token);
    }
}

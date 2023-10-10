package com.nva.server.apis;

import com.nva.server.dtos.UserForAdminDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class ApiUserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserForAdminDTO> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/current-user")
    public ResponseEntity<UserForClientDTO> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserForClientDTO currentUser = userService.findByEmail(userDetails.getUsername());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }
}

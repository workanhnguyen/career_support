package com.nva.server.apis;

import com.nva.server.dtos.ResponseForClientDTO;
import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.pojos.Response;
import com.nva.server.pojos.User;
import com.nva.server.services.HollandService;
import com.nva.server.services.ResponseService;
import com.nva.server.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/responses")
@Slf4j
public class ApiResponseController {
    @Autowired
    private HollandService hollandService;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private UserService userService;
    @PostMapping("/holland")
    public ResponseEntity<List<ResultHollandResponseDTO>> calculateHollandResult(@RequestBody ResponseSurveyHollandFromClientDTO response) {
        return new ResponseEntity<>(responseService.calculateAndSaveHollandResult(response), HttpStatus.OK);
    }

    @GetMapping("/by-current-user")
    public ResponseEntity<List<ResponseForClientDTO>> findByCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserForClientDTO currentUser = userService.findByEmail(userDetails.getUsername());
        
        return new ResponseEntity<>(responseService.findByUserId(currentUser.getId()), HttpStatus.OK);
    }
}

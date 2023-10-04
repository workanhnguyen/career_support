package com.nva.server.controllers;

import com.nva.server.dtos.HollandDTO;
import com.nva.server.services.HollandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hollands")
@CrossOrigin
public class ApiHollandController {
    @Autowired
    private HollandService hollandService;
    @GetMapping
    public ResponseEntity<List<HollandDTO>> getAll() {
        return new ResponseEntity<>(hollandService.findAll(), HttpStatus.OK);
    }
}

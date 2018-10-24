package com.krhonos.contrat.controller;

import com.krhonos.contrat.model.ContratService;
import com.krhonos.contrat.dao.ContratServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")


public class ContratServiceController {

    @Autowired
    ContratServiceDao contratServiceDao;

    @GetMapping("/contrat_service")
    // TODO: finir le codagement



}
package com.krhonos.salaried.controller;


import com.krhonos.salaried.dao.UtilisateurDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtilisateurController {

    UtilisateurDao utilisateurDao;
}

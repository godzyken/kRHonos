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
    public List<ContratService> getAllContratService() {
        System.out.println("Récupération de la liste des services ratachés aux contrats");

        List<ContratService> contratService = new ArrayList<>();
        contratServiceDao.findAll().forEach(contratService::add);

        return contratService;
    }

    @PostMapping(value = "/contrats/create")
    public ContratService postContrat(@RequestBody ContratService contratService) {
        return contratServiceDao.save(
                new ContratService(
                        contratService.getDateDebut(),
                        contratService.getDateFin()));
    }

    @DeleteMapping("/contrats/{id}")
    public ResponseEntity<String> deleteContrat(@PathVariable("id") long id) {
        System.out.println("Suppression du contrat ace l'id= $id...");

        contratServiceDao.deleteById(id);

        return new ResponseEntity<>("Le contrat a été supprimé", HttpStatus.OK);
    }

    @PutMapping("/contrat_service_controller/{id}")
    public ResponseEntity<ContratService> updateContratService(@PathVariable("id") long id, @RequestBody ContratService contratService) {
        System.out.println("Contrat service avec l'id: $id mis à jour... ");
        return null;
    }



}
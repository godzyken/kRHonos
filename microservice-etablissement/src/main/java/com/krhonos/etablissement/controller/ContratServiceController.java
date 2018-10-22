package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.model.ContratService;
import com.krhonos.etablissement.repository.ContratServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContratServiceController {

    @Autowired
    ContratServiceRepository repository;

    @GetMapping("/contratServices")
    public List<ContratService> getAllContratsServices() {
        List<ContratService> contratServices = new ArrayList<>();
        repository.findAll().forEach(contratServices::add);
        return contratServices;
    }

    @GetMapping("/contratServices/{id}")
    public ContratService findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }

        return null;
    }

    @PostMapping("/contratServices/create")
    public ContratService postContratService(@RequestBody ContratService contratService) {
        return repository.save(
                new ContratService(
                        contratService.getServiceId(),
                        contratService.getDateStart(),
                        contratService.getDateEnd()));
    }
}

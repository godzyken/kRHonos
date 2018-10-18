package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.model.Service;
import com.krhonos.etablissement.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    ServiceRepository repository;

    @GetMapping("/services")
    public List<Service> getAllServices() {
        System.out.println("Liste de tous les services");

        List<Service> services = new ArrayList<>();
        repository.findAll().forEach(services::add);
        return services;
    }

    @GetMapping("/services/id/{id}")
    public Service findById(@PathVariable long id) {
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }

        return null;
    }

    @PostMapping(value = "/Services/create")
    public Service postService(@RequestBody Service service) {
        return repository.save(
                new Service(
                        service.getNom(),
                        service.getEtabId()));
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") long id, @RequestBody Service service) {
        System.out.println("Update service with id $id");

        Optional<Service> serviceData = repository.findById(id);

        if(serviceData.isPresent()) {
            Service _service = serviceData.get();
            _service.setNom(service.getNom());
            _service.setEtabId(service.getEtabId());
            return new ResponseEntity<>(repository.save(_service), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

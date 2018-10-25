package com.krhonos.contrat.controller;

import com.krhonos.contrat.dao.ServiceDao;
import com.krhonos.contrat.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    ServiceDao serviceDao;

    @GetMapping("/services")
    public List<Service> getAllServices() {

        List<Service> services = new ArrayList<>();
        serviceDao.findAll().forEach(services::add);

        return services;
    }

    @PostMapping(value = "/services/create")
    public  Service postService(@RequestBody Service service) {
        return serviceDao.save(new Service(service.getNom()));
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") long id) {
        serviceDao.deleteById(id);

        return new ResponseEntity<>("Le service $id a été supprimé.", HttpStatus.OK);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") long id, @RequestBody Service service) {
        return null;
    }



}

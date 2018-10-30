package com.krhonos.contrat.controller;

import com.krhonos.contrat.dao.ServiceDao;
import com.krhonos.contrat.model.Service;
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
    ServiceDao serviceDao;

    @GetMapping("/services")
    public List<Service> getAllServices() {

        List<Service> services = new ArrayList<>();
        serviceDao.findAll().forEach(services::add);

        return services;
    }

    @PostMapping(value = "/services/create")
    public  Service postService(@RequestBody Service service) {
        return serviceDao.save(new Service(service.getNom(), service.getEtabId(), service.getContratService()));
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") long id) {
        serviceDao.deleteById(id);

        return new ResponseEntity<>("Le service $id a été supprimé.", HttpStatus.OK);
    }

    @GetMapping(value = "services/{id}")
    public ResponseEntity<Service> findById(@PathVariable long id) {
        if(serviceDao.findById(id).isPresent()){
            return new ResponseEntity<>(serviceDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") long id, @RequestBody Service service) {
        Optional<Service> serviceData = serviceDao.findById(id);

        if(serviceData.isPresent()){
            Service _service = serviceData.get();
            _service.setId(service.getId());
            _service.setNom(service.getNom());
            _service.setEtabId(service.getEtabId());
            _service.setContratService(service.getContratService());
            return new ResponseEntity<>(serviceDao.save(_service), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

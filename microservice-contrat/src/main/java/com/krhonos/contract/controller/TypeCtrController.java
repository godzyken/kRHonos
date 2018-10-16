package com.krhonos.contract.controller;

import com.krhonos.contract.model.TypeCtr;
import com.krhonos.contract.repository.TypeCtrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TypeCtrController {

  @Autowired
  TypeCtrRepository repository;

  @GetMapping("/typeCtr")
  public List<TypeCtr> getAllType() {
    System.out.println("Récupère tous les types");

    List<TypeCtr> typeCtrs = new ArrayList<>();
    repository.findAll().forEach(typeCtrs::add);

    return typeCtrs;
  }

  @GetMapping("/typeCtr/id/{id}")
  public TypeCtr findById(@PathVariable long id) {

    if(repository.findById(id).isPresent()) {
      return repository.findById(id).get();
    }

    return null;
  }
}

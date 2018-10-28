package com.krhonos.personne.controller;

import com.krhonos.personne.model.SituationFamiliale;
import com.krhonos.personne.dao.SituationFamilialeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SituationFamilialeController {
    @Autowired
    SituationFamilialeDao situationFamilialeDao;

    @GetMapping("/familySituations")
    public List<SituationFamiliale> getAllfamilySituation() {
        List<SituationFamiliale> situationFamilialeList = new ArrayList<>();
        situationFamilialeDao.findAll().forEach(situationFamilialeList::add);
        return situationFamilialeList;
    }
}

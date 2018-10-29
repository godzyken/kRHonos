package com.krhonos.personne.controller;

import com.krhonos.personne.dao.DocDiplomeDao;
import com.krhonos.personne.model.DocDiplome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DocDiplomeController {

    @Autowired
    DocDiplomeDao docDiplomeDao;

    @GetMapping("/docdiplome")
    public List<DocDiplome> getAllDocDiplome() {
        List<DocDiplome> docDiplomes = new ArrayList<>();
        docDiplomeDao.findAll().forEach(docDiplomes::add);

        return docDiplomes;
    }


    @GetMapping(value = "docdiplome/{id}")
    public DocDiplome findById(@PathVariable long id) {

        if (docDiplomeDao.findById(id).isPresent()) {
            return docDiplomeDao.findById(id).get();
        }
        return null;
    }
}

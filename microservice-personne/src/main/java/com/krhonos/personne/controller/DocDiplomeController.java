package com.krhonos.personne.controller;

import com.krhonos.personne.dao.DocDiplomeDao;
import com.krhonos.personne.model.DocDiplome;
import com.krhonos.personne.model.DocDiplome;
import com.krhonos.personne.service.ModelMapperService;
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
    @Autowired
    ModelMapperService modelMapperService;

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

    @PutMapping(value = "/docdiplome/update/{id}")
    public DocDiplome updateCandidat(@PathVariable long id, @RequestBody DocDiplome docdiplome) {
        DocDiplome _docdiplome = docDiplomeDao.findById(id).get();
        if (_docdiplome != null) {
            modelMapperService.map(docdiplome, _docdiplome);
            docDiplomeDao.save(_docdiplome);
        }
        return _docdiplome;
    }

    @DeleteMapping(value = "/docdiplome/delete/{id}")
    public void deleteCandidat(@PathVariable long id){
        docDiplomeDao.deleteById(id);
    }


}

package com.krhonos.personne.controller;

import com.krhonos.personne.dao.DiplomeDao;
import com.krhonos.personne.model.Diplome;
import com.krhonos.personne.model.Diplome;
import com.krhonos.personne.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DiplomeController {
    @Autowired
    DiplomeDao diplomeDao;

    @Autowired
    ModelMapperService modelMapperService;


    //Find All
    @GetMapping(value = "/diplome")
    public List<Diplome> getAllDiplome() {
        List<Diplome> diplomes = new ArrayList<>();
        diplomeDao.findAll().forEach(diplomes::add);

        return diplomes;
    }

    //Find By ID
    @GetMapping(value = "/diplome/{id}")
    public Diplome findById(@PathVariable long id) {

        if (diplomeDao.findById(id).isPresent()) {
            return diplomeDao.findById(id).get();
        }
        return null;
    }

    @PostMapping(value = "/diplome/create")
    public Diplome postDiplome(@RequestBody Diplome diplome) {
        Diplome _diplome =
                diplomeDao.save(
                        new Diplome(
                                diplome.getLibelle(),
                                diplome.isObtention(),
                                diplome.getAnneeObtention(),
                                diplome.getSalarie()
                        )
                );
        return _diplome;
    }

    @PutMapping(value = "/diplome/update/{id}")
    public Diplome updateCandidat(@PathVariable long id, @RequestBody Diplome diplome) {
        Diplome _diplome = diplomeDao.findById(id).get();
        if (_diplome != null) {
            modelMapperService.map(diplome, _diplome);
            diplomeDao.save(_diplome);
        }
        return _diplome;
    }

    @DeleteMapping(value = "/diplome/delete/{id}")
    public void deleteCandidat(@PathVariable long id){
        diplomeDao.deleteById(id);
    }
}

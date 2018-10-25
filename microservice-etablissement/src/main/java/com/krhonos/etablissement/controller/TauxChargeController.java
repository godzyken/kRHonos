package com.krhonos.etablissement.controller;

import com.krhonos.etablissement.dao.TauxChargeDao;
import com.krhonos.etablissement.model.TauxCharge;
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
public class TauxChargeController {

    @Autowired
    TauxChargeDao tauxChargeDao;

    @GetMapping("/taux_charges")
    public List<TauxCharge> getAllTauxCharges() {

        List<TauxCharge> tauxCharges = new ArrayList<>();
        tauxChargeDao.findAll().forEach(tauxCharges::add);

        return tauxCharges;
    }

    @PostMapping(value = "/taux_charges/create")
    public TauxCharge postTauxCharge(@RequestBody TauxCharge tauxCharge) {
        TauxCharge _tauxCharge = tauxChargeDao.save(new TauxCharge(
                tauxCharge.getLibelle(),
                tauxCharge.getValeur(),
                tauxCharge.getDateEffet(),
                tauxCharge.getStatut(),
                tauxCharge.getEmplois()));
        return _tauxCharge;
    }

    @DeleteMapping("/taux_charges/{id}")
    public ResponseEntity<String> deleteTauxCharge(@PathVariable("id") long id) {
        System.out.println("Suppression de la tauxCharges avec l'id : $id...");

        tauxChargeDao.deleteById(id);

        return new ResponseEntity<>("La tauxCharge a été supprimé", HttpStatus.OK);
    }

    @GetMapping(value = "taux_charges/{id}")
    public ResponseEntity<TauxCharge> findById(@PathVariable long id) {
        if(tauxChargeDao.findById(id).isPresent()){
            return new ResponseEntity<>(tauxChargeDao.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/taux_charges/{id}")
    public ResponseEntity<TauxCharge> updateTauxCharge(@PathVariable("id") long id, @RequestBody TauxCharge tauxCharge) {
        System.out.println("La tauxCharge avec l'id $id a été mis à jour...");

        Optional<TauxCharge> tauxChargeData = tauxChargeDao.findById(id);

        if(tauxChargeData.isPresent()){
            TauxCharge _tauxCharge = tauxChargeData.get();
            _tauxCharge.setLibelle(tauxCharge.getLibelle());
            _tauxCharge.setValeur(tauxCharge.getValeur());
            _tauxCharge.setDateEffet(tauxCharge.getDateEffet());
            _tauxCharge.setStatut(tauxCharge.getStatut());
            _tauxCharge.setEmplois(tauxCharge.getEmplois());
            return new ResponseEntity<>(tauxChargeDao.save(_tauxCharge), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

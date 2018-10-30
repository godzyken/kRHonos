package com.krhonos.personne.controller;

import com.krhonos.personne.dao.DocumentDao;
import com.krhonos.personne.model.Document;
import com.krhonos.personne.model.Document;
import com.krhonos.personne.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DocumentController {
    @Autowired
    DocumentDao documentDao;
    @Autowired
    ModelMapperService modelMapperService;


    @GetMapping("/document")
    public List<Document> getAllSalaried() {
        List<Document> documents = new ArrayList<>();
        documentDao.findAll().forEach(documents::add);

        return documents;
    }

    @GetMapping(value = "/document/{id}")
    public Document findById(@PathVariable long id) {

        if (documentDao.findById(id).isPresent()) {
            return documentDao.findById(id).get();
        }
        return null;
    }

    @PostMapping(value = "/document/create")
    public Document postDocument(@RequestBody Document document) {
        Document _document =
                documentDao.save(
                        new Document(
                                document.getRib(),
                                document.getSecu(),
                                document.getSalarie()
                        )
                );

        return _document;
    }

    @PutMapping(value = "/document/update/{id}")
    public Document updateDocument(@PathVariable long id, @RequestBody Document document) {
        Document _document = documentDao.findById(id).get();
        if (_document != null) {
            modelMapperService.map(document, _document);
            documentDao.save(_document);
        }
        return _document;
    }

    @DeleteMapping(value = "/document/delete/{id}")
    public void deleteDocument(@PathVariable long id) {
        documentDao.deleteById(id);
    }
}

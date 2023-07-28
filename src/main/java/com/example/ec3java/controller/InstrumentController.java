package com.example.ec3java.controller;

import com.example.ec3java.entities.InstrumentEntity;
import com.example.ec3java.repository.ICategoryRepository;
import com.example.ec3java.repository.IInstrumentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("instrumentos")
public class InstrumentController {

    private final IInstrumentRepository _repository;
    private final ICategoryRepository _repositoryCategory;

    public InstrumentController(IInstrumentRepository repository, ICategoryRepository repositoryCategory) {
        this._repository = repository;
        _repositoryCategory = repositoryCategory;
    }
    
    @GetMapping("/")
    public ResponseEntity<Iterable<InstrumentEntity>> find() {
        return new ResponseEntity<>(this._repository.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<Iterable<InstrumentEntity>> insert(@RequestBody InstrumentEntity instrument) {
        try {
            instrument.category = this._repositoryCategory.findById(instrument.category.id).orElse(null);
            this._repository.save(instrument);
            return new ResponseEntity<>(this._repository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(this._repository.findAll(), HttpStatus.OK);
        }
    }
    
}

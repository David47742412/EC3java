package com.example.ec3java.controller;

import com.example.ec3java.entities.CategoryEntity;
import com.example.ec3java.repository.ICategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categorias")
public class CategoryController {

    private final ICategoryRepository _repository;

    public CategoryController(ICategoryRepository _repository) {
        this._repository = _repository;
    }
    
    @GetMapping("/")
    public Iterable<CategoryEntity> find() {
        return this._repository.findAll();
    }
    
    @PostMapping("/")
    public ResponseEntity<Iterable<CategoryEntity>> insert(@RequestBody CategoryEntity categoryEntity) {
        try {
            this._repository.save(categoryEntity);
            return new ResponseEntity<>(this._repository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(this._repository.findAll(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

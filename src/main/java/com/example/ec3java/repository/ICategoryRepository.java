package com.example.ec3java.repository;

import com.example.ec3java.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categorias")
public interface ICategoryRepository extends CrudRepository<CategoryEntity, String> {
    List<CategoryEntity> findByName(@Param("name") String name);
}

package com.example.ec3java.repository;

import com.example.ec3java.entities.InstrumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "instruments", path = "instrumentos")
public interface IInstrumentRepository extends CrudRepository<InstrumentEntity, String>, PagingAndSortingRepository<InstrumentEntity, String> {
    List<InstrumentEntity> findByName(@Param("name") String name);
}

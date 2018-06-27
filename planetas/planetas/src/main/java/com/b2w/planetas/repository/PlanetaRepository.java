package com.b2w.planetas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.b2w.planetas.entity.Planeta;


public interface PlanetaRepository extends MongoRepository<Planeta, String> {

    public Planeta findByNome(String nome);
}

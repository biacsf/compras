package com.b2w.planetas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.b2w.planetas.entity.Planeta;


public interface PlanetaRepository extends MongoRepository<Planeta, String> {

    /**
     * O Spring data cria automaticamente a query quando definido um metodo com a sintaxe findByAtributo 
     * 
     * Porem, caso seja necessario customizar a query no MongoDB, e possivel utilizar a anotacao @Query 
     * 
     * @param nome
     * @return
     */
    @Query("{'nome':?0}")
    public Planeta findByNome(String nome);
}

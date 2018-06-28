package com.b2w.planetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.planetas.entity.Planeta;
import com.b2w.planetas.repository.PlanetaRepository;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    PlanetaRepository planetaRepository;
    
    /**
     *  db.planetas.insert({nome: "?", clima: "?", terreno: "?"})
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPlaneta(@RequestBody Planeta planeta) {
	planetaRepository.save(planeta);
    }
    
    /**
     *  db.planetas.find({})
     */
    @RequestMapping(method = RequestMethod.GET) 
    public List<Planeta> listar() {
        return planetaRepository.findAll();
    }

    /**
     *  db.planetas.find({nome: "?"})
     */
    @RequestMapping(value = "/nome/{nome}",method = RequestMethod.GET) 
    public Planeta buscarPorNome(@PathVariable String nome) {
        return planetaRepository.findByNome(nome);
    }
    
    /**
     *  db.planetas.find({id: "?"})
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET) 
    public Planeta buscarPorId(@PathVariable String id) {
        return planetaRepository.findById(id).get();
    }
    
    /**
     *  db.planetas.deleteOne({id: "?"})
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
    public void delete(@PathVariable Planeta planeta) {
	planetaRepository.delete(planeta);
    }
    
}

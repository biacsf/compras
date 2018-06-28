package com.b2w.planetas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.b2w.planetas.entity.Planeta;
import com.b2w.planetas.repository.PlanetaRepository;

public class PlanetaServiceImpl implements PlanetaService {

    @Autowired
    PlanetaRepository planetaRepository;

    /**
     * db.planetas.insert({nome: "?", clima: "?", terreno: "?"})
     */
    @Override
    public void addPlaneta(Planeta planeta) {
	planetaRepository.save(planeta);
    }

    /**
     * db.planetas.find({})
     */
    @Override
    public List<Planeta> listar() {
	return planetaRepository.findAll();
    }

    /**
     * db.planetas.find({nome: "?"})
     */
    @Override
    public Planeta buscarPorNome(@PathVariable String nome) {
	return planetaRepository.findByNome(nome);
    }

    /**
     * db.planetas.find({id: "?"})
     */
    @Override
    public Planeta buscarPorId(@PathVariable String id) {
	return planetaRepository.findById(id).get();
    }

    /**
     * db.planetas.deleteOne({id: "?"})
     */
    @Override
    public void delete(@PathVariable Planeta planeta) {
	planetaRepository.delete(planeta);
    }
}

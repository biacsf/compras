package com.b2w.planetas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.planetas.api.StarWarsWSClient;
import com.b2w.planetas.entity.Planeta;
import com.b2w.planetas.repository.PlanetaRepository;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	PlanetaRepository planetaRepository;

	@Autowired
	StarWarsWSClient starWarsWSClient;
	
	private final Logger logger = LoggerFactory.getLogger(PlanetaServiceImpl.class);

	/**
	 * db.planetas.insert({nome: "?", clima: "?", terreno: "?"})
	 */
	@Override
	public void addPlaneta(Planeta planeta) {
		
		logger.info("Salva o planeta: "+planeta+" na base de dados.");

		planeta.setQtdAparicoesFilmes(starWarsWSClient.buscaQuantidadeAparicoesEmFilmes(planeta.getNome()));
		
		logger.info("Encontrou: "+planeta.getQtdAparicoesFilmes()+" aparicoes em filmes do planeta: "+planeta.getNome()+" na API Swapi");

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
	public Planeta buscarPorNome(String nome) {
		return planetaRepository.findByNome(nome);
	}

	/**
	 * db.planetas.find({id: "?"})
	 */
	@Override
	public Planeta buscarPorId(String id) {
		return planetaRepository.findById(id).get();
	}

	/**
	 * db.planetas.deleteOne({id: "?"})
	 */
	@Override
	public void delete(String id) {
		planetaRepository.deleteById(id);
	}
}

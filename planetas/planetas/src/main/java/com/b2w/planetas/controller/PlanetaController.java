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
import com.b2w.planetas.service.PlanetaService;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

	@Autowired
	PlanetaService planetaService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addPlaneta(@RequestBody Planeta planeta) {
		planetaService.addPlaneta(planeta);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Planeta> listar() {
		return planetaService.listar();
	}

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Planeta buscarPorNome(@PathVariable String nome) {
		return planetaService.buscarPorNome(nome);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Planeta buscarPorId(@PathVariable String id) {
		return planetaService.buscarPorId(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		planetaService.delete(id);
	}

}

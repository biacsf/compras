package com.b2w.planetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.planetas.dto.JsonResponse;
import com.b2w.planetas.entity.Planeta;
import com.b2w.planetas.service.PlanetaService;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

	@Autowired
	PlanetaService planetaService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Planeta> addPlaneta(@RequestBody Planeta planeta) {
		return new ResponseEntity<>(planetaService.addPlaneta(planeta), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Planeta>> listar() {
		return new ResponseEntity<>(planetaService.listar(), HttpStatus.OK);
	}

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Planeta> buscarPorNome(@PathVariable String nome) {
		return new ResponseEntity<>(planetaService.buscarPorNome(nome), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Planeta> buscarPorId(@PathVariable String id) {
		return new ResponseEntity<>(planetaService.buscarPorId(id), HttpStatus.OK);
	}

	@ResponseStatus(code= HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		planetaService.delete(id);
	}

}

package com.b2w.planetas.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.b2w.planetas.entity.Planeta;

public interface PlanetaService {

    public void addPlaneta(Planeta planeta);

    public List<Planeta> listar();

    public Planeta buscarPorNome(@PathVariable String nome);

    public Planeta buscarPorId(@PathVariable String id);

    public void delete(@PathVariable Planeta planeta);
}

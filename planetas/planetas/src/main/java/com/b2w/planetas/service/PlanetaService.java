package com.b2w.planetas.service;

import java.util.List;

import com.b2w.planetas.entity.Planeta;

public interface PlanetaService {

    public Planeta addPlaneta(Planeta planeta);

    public List<Planeta> listar();

    public Planeta buscarPorNome(String nome);

    public Planeta buscarPorId(String id);

	void delete(String id);
}

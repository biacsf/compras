package com.b2w.planetas.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.b2w.planetas.entity.Planeta;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PlanetaRepositoryTests {

	@Autowired
	private PlanetaRepository planetaRepository;

	Planeta terra;
	Planeta marte;

	@Before
	public void setUp() throws Exception {

		terra = new Planeta("Terra", "Diversificado", "Florestas", 2);
		marte = new Planeta("Marte", "Seco", "Alcalino", 1);

	}

	@Test
	public void testSaveAndFindAll() {
		planetaRepository.save(terra);

		List<Planeta> result = planetaRepository.findAll();
		assertThat(result, hasItem(terra));
	}
	
	@Test
	public void testSaveAndFindById() {
		Planeta planeta = planetaRepository.save(terra);

		Optional<Planeta> result = planetaRepository.findById(planeta.getId());
		assertThat(result.get().getNome(), is(terra.getNome()));
	}


}

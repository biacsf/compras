package com.b2w.planetas.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
	public void testSaveAndFindAllAndDelete() {
		Planeta planeta = planetaRepository.save(terra);

		List<Planeta> result = planetaRepository.findAll();
		assertThat(result, hasItem(terra));
		
		planetaRepository.delete(planeta);
		
		Optional<Planeta> resultAfterDelete = planetaRepository.findById(planeta.getId());
		assertFalse(resultAfterDelete.isPresent());
	}
	
	@Test
	public void testSaveAndFindByIdAndDelete() {
		Planeta planeta = planetaRepository.save(marte);

		Optional<Planeta> resultAfterSave = planetaRepository.findById(planeta.getId());
		assertThat(resultAfterSave.get().getNome(), is(marte.getNome()));
		
		planetaRepository.delete(planeta);
		
		Optional<Planeta> resultAfterDelete = planetaRepository.findById(planeta.getId());
		assertFalse(resultAfterDelete.isPresent());
	}

}

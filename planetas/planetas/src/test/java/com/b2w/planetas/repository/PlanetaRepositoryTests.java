package com.b2w.planetas.repository;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matcher;
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

    @Before
    public void setUp() {

	Planeta planeta = new Planeta("Planeta 1","Seco","pedregoso",1);

	planetaRepository.save(planeta);
    }

    @Test
    public void findByName() {
	List<Planeta> result = planetaRepository.findAll();
	assertThat(result, is(1));
    }
}

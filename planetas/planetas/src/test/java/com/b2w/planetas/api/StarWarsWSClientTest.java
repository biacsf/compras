package com.b2w.planetas.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StarWarsWSClientTest {
    
	@Autowired
    private StarWarsWSClient starWarsWSClient;
    

    @Test
    public void testGetQuantidadeFilmesPorPlaneta() throws IOException {
    	int quantidade = starWarsWSClient.buscaQuantidadeAparicoesEmFilmes("Tatooine");

        assertThat(quantidade, equalTo(5));
    }
    
    @Test
    public void testGetPlaneta() throws IOException {
    	PlanetSwapi planeta = starWarsWSClient.recuperaPlaneta("Alderaan");

        assertThat(planeta.getName(), equalTo("Alderaan"));
        assertThat(planeta.getClimate(), equalTo("temperate"));
        assertThat(planeta.getDiameter(), equalTo("12500"));
    }
    
    @Test
    public void testGetPlanetaNaoExistente() throws IOException {
    	PlanetSwapi planeta = starWarsWSClient.recuperaPlaneta("XXXXYYYYY");

        assertThat(planeta, equalTo(null));
    }
    
    @Test
    public void testGetQuantidadeFilmesPorPlanetaNaoExistente() throws IOException {
    	Integer quantidade = starWarsWSClient.buscaQuantidadeAparicoesEmFilmes("XXXXYYYYY");

        assertThat(quantidade, equalTo(null));
    }
}

package com.b2w.planetas.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.b2w.planetas.entity.Planeta;
import com.b2w.planetas.service.PlanetaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PlanetaController.class)
public class PlanetaControllerTest {

	private MockMvc mockMvc;

	@MockBean
	private PlanetaService planetaService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	Planeta terra;
	Planeta marte;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		terra = new Planeta("Terra", "Diversificado", "Florestas", 2);
		marte = new Planeta("Marte", "Seco", "Alcalino", 1);
	}

	@Test
	public void testListarPlanetas() throws Exception {

		when(planetaService.listar()).thenReturn(Arrays.asList(marte, terra));

		this.mockMvc.perform(get("/planetas")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
	}

	@Test
	public void testBuscarPlanetaPorNome() throws Exception {

		when(planetaService.buscarPorNome(anyString())).thenReturn(marte);

		this.mockMvc.perform(get("/planetas/nome/Marte").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nome", is("Marte")));

	}

	@Test
	public void testBuscarPlanetaPorId() throws Exception {

		when(planetaService.buscarPorId(anyString())).thenReturn(marte);

		this.mockMvc.perform(get("/planetas/1234").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nome", is("Marte")));

	}
	
	@Test
	public void testAdicionarPlaneta() throws Exception {

		String body = (new ObjectMapper()).valueToTree(terra).toString();


		this.mockMvc.perform(post("/planetas").contentType(MediaType.APPLICATION_JSON)
                .content(body))
		.andExpect(status().isOk());

	}
	
	@Test
	public void testRemoverPlaneta() throws Exception {

		this.mockMvc.perform(delete("/planetas/1234").contentType(MediaType.APPLICATION_FORM_URLENCODED))
		.andExpect(status().isOk());

	}
}

package com.b2w.planetas.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StarWarsWSClientTest {
    
    private RestTemplate restTemplate;

    @Before
    public void beforeTest() {
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
    }
    
    @Test
    public void testGetQuantidadeFilmesPorPlaneta() throws IOException {
        final ResponseEntity<String> response = restTemplate.getForEntity("https://swapi.co/api/planets/?search=Yavin IV", String.class);

        ObjectMapper mapper = new ObjectMapper();
        int quantidade = mapper.readTree(response.getBody()).path("filmes").size();
        assertThat(quantidade, equalTo(1));
    }
}

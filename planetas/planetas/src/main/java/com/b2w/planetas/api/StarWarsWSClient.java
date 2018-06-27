package com.b2w.planetas.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class StarWarsWSClient {

    @Value("${starwars.api.server.base_uri}")
    private String baseApiUri;

    public static void buscaPlaneta(String nomePlaneta) {

	RestTemplate restTemplate = new RestTemplate();
	PlanetaSwapi planeta = restTemplate.getForObject("https://swapi.co/api/planets/?search=Yavin IV", PlanetaSwapi.class);
    }
    

    public static void main(String[] args) {
	buscaPlaneta("");
    }
    
    
}

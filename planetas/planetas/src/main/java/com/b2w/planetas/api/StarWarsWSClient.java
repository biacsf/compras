package com.b2w.planetas.api;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StarWarsWSClient {

    @Value("${starwars.api.server.base_uri}")
    private String baseApiUri;

    @Autowired
    private RestTemplate restTemplate;

    private final static HttpEntity<String> entity;
    
    private final Logger logger = LoggerFactory.getLogger(StarWarsWSClient.class);

    static {
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	entity = new HttpEntity<String>("parameters", headers);
    }

    public Integer buscaQuantidadeAparicoesEmFilmes(String nomePlaneta) {

	ObjectMapper mapper = new ObjectMapper();
	JsonNode root = null;

	ResponseEntity<String> response = restTemplate.exchange(baseApiUri + "planets/?search=" + nomePlaneta, HttpMethod.GET, entity, String.class);

	try {
	    root = mapper.readTree(response.getBody());

	} catch (IOException e) {
	    logger.error("Erro ao consultar a API do StarWars e buscar informacoes do planeta: "+nomePlaneta);
	    return null;
	}

	int quantidade = root.findPath("films").size();

	return quantidade;

    }
    
    
}

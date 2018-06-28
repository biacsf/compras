package com.b2w.planetas.api;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StarWarsWSClient {

	@Value("${starwars.api.server.base_uri}")
	private String baseApiUri;

	public static void buscaPlaneta(String nomePlaneta) {

		RestTemplate restTemplate = new RestTemplate(); 

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange("https://swapi.co/api/planets/?search="+nomePlaneta, HttpMethod.GET,
				entity, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		try {
			root = mapper.readTree(response.getBody());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int quantidade = root.findPath("films").size();


	}

	public static void main(String[] args) {
		buscaPlaneta("Yavin IV");
	}

}

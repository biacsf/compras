package com.b2w.planetas.api;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;

@Component
public class StarWarsWSClient {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Value("${starwars.api.server.base_uri}")
	private String baseApiUri;

	@Autowired
	private RestTemplate restTemplate;

	private final Logger logger = LoggerFactory.getLogger(StarWarsWSClient.class);

	private HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		return headers;
	}

	/**
	 * Retorna a quantidade de aparicoes em filmes
	 * Nesse caso o resultado esta sendo mapeado para json e o metodo findPath e utilizado para encontrar o no alvo
	 * 
	 * @param nomePlaneta
	 * @return
	 */
	public Integer buscaQuantidadeAparicoesEmFilmes(String nomePlaneta) {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;

		ResponseEntity<String> response = restTemplate.exchange(baseApiUri + "planets/?search=" + nomePlaneta,
				HttpMethod.GET, new HttpEntity<String>("parameters", createHttpHeaders()), String.class);

		try {
			root = mapper.readTree(response.getBody());

		} catch (IOException e) {
			logger.error("Erro ao consultar a API do StarWars e buscar informacoes do planeta: " + nomePlaneta);
			return null;
		}
		if(root.findPath("films").equals(MissingNode.getInstance())) {
			return null;
		}else {
			return root.findPath("films").size();
		}

	}

	/**
	 *  Nesse metodo o objeto retornado pela API foi mapeado na aplicacao
	 *  Recupera o Objeto planeta retornado pela API
	 *  
	 * @param nomePlaneta
	 * @return
	 */
	public PlanetSwapi recuperaPlaneta(String nomePlaneta) {

		ResponseEntity<SearchResponse> response = restTemplate.exchange(baseApiUri + "planets/?search=" + nomePlaneta,
				HttpMethod.GET, new HttpEntity<String>("parameters", createHttpHeaders()), SearchResponse.class);

		if (response.getBody() != null && response.getBody().getResults() != null
				&& !response.getBody().getResults().isEmpty()) {
			return response.getBody().getResults().get(0);
		} else {
			return null;
		}

	}

}

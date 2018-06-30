package com.b2w.planetas.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties
public class SearchResponse {

	@Getter
	@Setter
	private int count;

	@Getter
	@Setter
	private List<PlanetSwapi> results;
}

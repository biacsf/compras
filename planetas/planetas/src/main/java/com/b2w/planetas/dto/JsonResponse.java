package com.b2w.planetas.dto;

import java.util.List;

import com.b2w.planetas.api.PlanetSwapi;

import lombok.Getter;
import lombok.Setter;

public class JsonResponse {
	@Getter
	@Setter
	private int count;

	@Getter
	@Setter
	private List<PlanetSwapi> results;
}

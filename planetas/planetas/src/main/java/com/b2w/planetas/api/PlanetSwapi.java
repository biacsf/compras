package com.b2w.planetas.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties
public class PlanetSwapi {

	@Getter @Setter
	private String edited;
	@Getter @Setter
	private String terrain;
	@Getter @Setter
	private String gravity;
	@Getter @Setter
	private String diameter;
	@Getter @Setter
	private String population;
	@Getter @Setter
	private String orbital_period;
	@Getter @Setter
	private String[] residents;
	@Getter @Setter
	private String created;
	@Getter @Setter
	private String url;
	@Getter @Setter
	private String[] films; 
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String surface_water;
	@Getter @Setter
	private String rotation_period;
	@Getter @Setter
	private String climate;
}

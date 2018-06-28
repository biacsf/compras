package com.b2w.planetas.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetaSwapi {

    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private List<String> films;
}

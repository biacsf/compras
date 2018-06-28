package com.b2w.planetas.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames=true)
@EqualsAndHashCode
@Document(collection = "planetas")
public class Planeta {
    
    public Planeta(String nome, String clima, String terreno, Integer qtdAparicoesFilmes){
	this.nome = nome;
	this.clima = clima;
	this.terreno = terreno;
	this.qtdAparicoesFilmes = qtdAparicoesFilmes;
    }
    
    @Id @Getter @Setter
    private String id;

    @Getter @Setter
    private String nome;
    
    @Getter @Setter @EqualsAndHashCode.Exclude
    private String clima;
    
    @Getter @Setter @EqualsAndHashCode.Exclude
    private String terreno;
    
    @Getter @Setter @EqualsAndHashCode.Exclude
    private Integer qtdAparicoesFilmes;
    
}

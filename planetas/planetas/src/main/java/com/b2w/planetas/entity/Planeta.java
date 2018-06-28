package com.b2w.planetas.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

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
    
    @Getter @Setter
    private String clima;
    
    @Getter @Setter
    private String terreno;
    
    @Getter @Setter
    private Integer qtdAparicoesFilmes;

    @Override
    public String toString() {
	return "Planeta [nome=" + nome + ", clima=" + clima + ", terreno=" + terreno + ", qtdAparicoesFilmes=" + qtdAparicoesFilmes + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Planeta other = (Planeta) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	return true;
    }
    
    

}

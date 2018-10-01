package io.pagseguro.com.pack;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


@Entity
public class Cliente implements Serializable{

	//Classe cliente (model)
	@Id
	private String id;
	private String name;
	private int idade;
	private String current_weather;
	
	@Lob
	@Column(name="ip")
	private Ipvigilante ip;

	public Cliente() {
		super();
	}
	public Cliente(String id ,String name, int idade) {
		super();
		this.name = name;
		this.idade = idade;
		this.id =  id;
	}
	public Ipvigilante getIp() {
		return ip;
	}
	public void setIp(Ipvigilante ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCurrent_weather() {
		return current_weather;
	}
	public void setCurrent_weather(String current_weather) {
		this.current_weather = current_weather;
	}
}

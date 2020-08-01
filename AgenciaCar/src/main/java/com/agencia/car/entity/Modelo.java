package com.agencia.car.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "modelos")
public class Modelo implements Serializable {
	
	private static final long serialVersionUID = 3706546719469372401L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_modelo;
	
	@NotNull
	@Column(unique = true)
	private String name;
	
	@ManyToOne(optional = true)
	@JsonIgnoreProperties("modelo")
	private Marca marca;
	
	@OneToMany(mappedBy = "modelo")
	@JsonIgnore
	private Set<Coche> coche = new HashSet<>();

	public Long getId_modelo() {
		return id_modelo;
	}

	public void setId_modelo(Long id_modelo) {
		this.id_modelo = id_modelo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Set<Coche> getCoche() {
		return coche;
	}

	public void setCoche(Set<Coche> coche) {
		this.coche = coche;
	}

	
	
}

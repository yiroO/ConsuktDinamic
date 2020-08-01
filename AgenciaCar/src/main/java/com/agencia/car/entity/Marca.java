package com.agencia.car.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "marcas")
public class Marca implements Serializable {
	
	private static final long serialVersionUID = 5263230570319675520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_modelo;
	
	@NotNull
	@Column(unique = true)
	private String name;
	
	@OneToMany(mappedBy = "marca", fetch = FetchType.EAGER)
	private Set<Modelo> modelo = new HashSet<>();

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

	public Set<Modelo> getModelo() {
		return modelo;
	}

	public void setModelo(Set<Modelo> modelo) {
		this.modelo = modelo;
	}

	
	
}

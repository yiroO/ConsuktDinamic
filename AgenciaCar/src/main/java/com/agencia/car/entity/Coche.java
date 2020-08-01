package com.agencia.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.agencia.car.enums.Color;

@Entity
@Table(name = "coches")
public class Coche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_coche;
	
	@Column
	private String version;
	
	@Column
	private boolean cambios;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	@Column
	private int km;
	
	@ManyToOne(optional = false)
	private Modelo modelo;

	public Long getId_coche() {
		return id_coche;
	}

	public void setId_coche(Long id_coche) {
		this.id_coche = id_coche;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isCambios() {
		return cambios;
	}

	public void setCambios(boolean cambios) {
		this.cambios = cambios;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	

}

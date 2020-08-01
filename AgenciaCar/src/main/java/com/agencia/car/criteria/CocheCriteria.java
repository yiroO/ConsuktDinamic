package com.agencia.car.criteria;

import com.agencia.car.enums.Color;


import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

public class CocheCriteria {
	
	public static class ColorFilter extends Filter<Color> {}
	private StringFilter marca;
	private StringFilter modelo;
	private StringFilter version;
	private BooleanFilter cambios;
	private ColorFilter color;
	private IntegerFilter km;
	public StringFilter getMarca() {
		return marca;
	}
	public void setMarca(StringFilter marca) {
		this.marca = marca;
	}
	public StringFilter getModelo() {
		return modelo;
	}
	public void setModelo(StringFilter modelo) {
		this.modelo = modelo;
	}
	public StringFilter getVersion() {
		return version;
	}
	public void setVersion(StringFilter version) {
		this.version = version;
	}
	public BooleanFilter getCambios() {
		return cambios;
	}
	public void setCambios(BooleanFilter cambios) {
		this.cambios = cambios;
	}
	public ColorFilter getColor() {
		return color;
	}
	public void setColor(ColorFilter color) {
		this.color = color;
	}
	public IntegerFilter getKm() {
		return km;
	}
	public void setKm(IntegerFilter km) {
		this.km = km;
	}
	
	

}

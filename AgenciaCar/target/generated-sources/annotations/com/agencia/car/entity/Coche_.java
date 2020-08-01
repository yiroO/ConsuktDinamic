package com.agencia.car.entity;

import com.agencia.car.enums.Color;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Coche.class)
public abstract class Coche_ {

	public static volatile SingularAttribute<Coche, Integer> km;
	public static volatile SingularAttribute<Coche, Color> color;
	public static volatile SingularAttribute<Coche, Boolean> cambios;
	public static volatile SingularAttribute<Coche, Long> id_coche;
	public static volatile SingularAttribute<Coche, String> version;
	public static volatile SingularAttribute<Coche, Modelo> modelo;

	public static final String KM = "km";
	public static final String COLOR = "color";
	public static final String CAMBIOS = "cambios";
	public static final String ID_COCHE = "id_coche";
	public static final String VERSION = "version";
	public static final String MODELO = "modelo";

}


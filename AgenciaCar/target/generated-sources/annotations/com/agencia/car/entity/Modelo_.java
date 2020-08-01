package com.agencia.car.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modelo.class)
public abstract class Modelo_ {

	public static volatile SingularAttribute<Modelo, Marca> marca;
	public static volatile SetAttribute<Modelo, Coche> coche;
	public static volatile SingularAttribute<Modelo, Long> id_modelo;
	public static volatile SingularAttribute<Modelo, String> name;

	public static final String MARCA = "marca";
	public static final String COCHE = "coche";
	public static final String ID_MODELO = "id_modelo";
	public static final String NAME = "name";

}


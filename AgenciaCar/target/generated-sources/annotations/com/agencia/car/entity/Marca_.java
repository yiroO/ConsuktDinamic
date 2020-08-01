package com.agencia.car.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Marca.class)
public abstract class Marca_ {

	public static volatile SingularAttribute<Marca, Long> id_modelo;
	public static volatile SingularAttribute<Marca, String> name;
	public static volatile SetAttribute<Marca, Modelo> modelo;

	public static final String ID_MODELO = "id_modelo";
	public static final String NAME = "name";
	public static final String MODELO = "modelo";

}


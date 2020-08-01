package com.agencia.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.car.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}

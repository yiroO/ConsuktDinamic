package com.agencia.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.car.entity.Marca;
import com.agencia.car.repository.CocheRepository;
import com.agencia.car.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<Marca> list(){
		return marcaRepository.findAll();
	}

}

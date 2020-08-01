package com.agencia.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.car.entity.Marca;
import com.agencia.car.service.MarcaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/marca")
public class MacaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Marca>> list(){
		List<Marca> marcas = marcaService.list();
		if(marcas == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Marca>>(marcas, HttpStatus.OK);
	}
}

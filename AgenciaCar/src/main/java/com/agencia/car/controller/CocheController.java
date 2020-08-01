package com.agencia.car.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.car.criteria.CocheCriteria;
import com.agencia.car.dto.BusquedaDTO;
import com.agencia.car.entity.Coche;
import com.agencia.car.enums.Color;
import com.agencia.car.service.CocheService;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coche")
public class CocheController {
	
	@Autowired
	private CocheService cocheService;
	
	@PostMapping("/list")
	public ResponseEntity<List<Coche>> list(@RequestBody BusquedaDTO busquedaDTO){
		CocheCriteria cocheCriteria = createCriteria(busquedaDTO);
		List<Coche> coches = cocheService.findAllByCriteria(cocheCriteria);
		if(coches == null) {
			return new ResponseEntity<List<Coche>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Coche>>(coches, HttpStatus.OK);
	}
	
	
	private CocheCriteria createCriteria( BusquedaDTO busquedaDTO) {
		CocheCriteria cocheCriteria = new CocheCriteria();
		if(busquedaDTO != null) {
			
			if(!StringUtils.isBlank(busquedaDTO.getMarca())) {
				StringFilter filter = new StringFilter();
				filter.setEquals(busquedaDTO.getMarca());
				cocheCriteria.setMarca(filter);
			}
			
			if(!StringUtils.isAllBlank(busquedaDTO.getModelo())) {
				StringFilter filter = new StringFilter();
				filter.setEquals(busquedaDTO.getModelo());
				cocheCriteria.setModelo(filter);
			}
			
			if(!StringUtils.isAllBlank(busquedaDTO.getVersion())) {
				StringFilter filter = new StringFilter();
				filter.setContains(busquedaDTO.getVersion());
				cocheCriteria.setVersion(filter);
			}
			
			if(!StringUtils.isAllBlank(busquedaDTO.getCambios())) {
				BooleanFilter filter = new BooleanFilter();
				switch (busquedaDTO.getCambios()) {
				case "true":
					filter.setEquals(true);
					break;
				case "false":
					filter.setEquals(false);
					break;
				default: 
					filter.setEquals(false);
					break;
				}
				cocheCriteria.setCambios(filter);
			}
			
			if(!StringUtils.isBlank(busquedaDTO.getColor())) {
				CocheCriteria.ColorFilter colorFilter = new CocheCriteria.ColorFilter();
				String color = busquedaDTO.getColor().toUpperCase();
				colorFilter.setEquals(Color.valueOf(color));
				cocheCriteria.setColor(colorFilter);
			}
			
			if(busquedaDTO.getKmDesde() != null || busquedaDTO.getKmHasta() != null) {
				IntegerFilter filter = new IntegerFilter();
				if(busquedaDTO.getKmDesde() != null) {
					filter.setGreaterThanOrEqual(busquedaDTO.getKmDesde());
					cocheCriteria.setKm(filter);
				}
				if(busquedaDTO.getKmHasta() != null) {
					filter.setLessThanOrEqual(busquedaDTO.getKmHasta());
					cocheCriteria.setKm(filter);
				}
			}
		}
		return cocheCriteria;
	}

}

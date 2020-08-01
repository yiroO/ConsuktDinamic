package com.agencia.car.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.agencia.car.criteria.CocheCriteria;
import com.agencia.car.entity.Coche;
import com.agencia.car.entity.Coche_;
import com.agencia.car.entity.Marca_;
import com.agencia.car.entity.Modelo_;
import com.agencia.car.repository.CocheRepository;

import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class CocheService extends QueryService<Coche> {
	
	@Autowired
	private CocheRepository cocheRepository;
	
	public List<Coche> findAllByCriteria(CocheCriteria cocheCriteria){
		final Specification<Coche> specification = cocheSpecificationCriteria(cocheCriteria);
		List<Coche> cocheList = cocheRepository.findAll(specification);
		return cocheList;
	}
	
	public Specification<Coche> cocheSpecificationCriteria(CocheCriteria cocheCriteria){
		Specification<Coche> specification = Specification.where(null);
		if(cocheCriteria != null) {
			
			if(cocheCriteria.getVersion() != null) {
				specification = specification.and(buildStringSpecification(cocheCriteria.getVersion(), Coche_.version));
			}
			
			if(cocheCriteria.getColor() != null) {
				specification = specification.and(buildSpecification(cocheCriteria.getColor(), Coche_.color));
			}
			
			if(cocheCriteria.getKm() != null) {
				specification = specification.and(buildRangeSpecification(cocheCriteria.getKm(), Coche_.km));
			}
			
			if(cocheCriteria.getCambios() != null) {
				specification = specification.and(buildSpecification(cocheCriteria.getCambios(), Coche_.cambios));
			}
			
			if(cocheCriteria.getModelo() != null) {
				specification = specification.and(buildReferringEntitySpecification(cocheCriteria.getModelo(), Coche_.modelo, Modelo_.name));
			}
			
			if(cocheCriteria.getMarca() != null) {
				specification = specification.and(buildSpecification(cocheCriteria.getMarca(), root->root.join(Coche_.modelo, JoinType.LEFT)
                        .join(Modelo_.marca, JoinType.LEFT).get(Marca_.name)));
			}
		}
		return specification;
	}
	
	

}

package com.api.tcc.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tcc.adapter.HospitalRepository;
import com.api.tcc.adapter.mapper.HospitalMapper;
import com.api.tcc.core.model.Hospital;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository repository;
		
	public Hospital save(Hospital model) throws Exception {
		model.setId(UUID.randomUUID().toString().toUpperCase());
		return HospitalMapper.converterDTO(repository.save(HospitalMapper.converterEntity(model)));
	}
	
	public List<Hospital> getAll(){
		return HospitalMapper.converterListaDTO(repository.findAll());
	}
	
	public List<Hospital> getByCep(String cep) {
		return HospitalMapper.converterListaDTO(repository.findByCep(cep).orElse(null));
	}
}

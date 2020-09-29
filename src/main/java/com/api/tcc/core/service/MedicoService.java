package com.api.tcc.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tcc.adapter.MedicoRepository;
import com.api.tcc.adapter.mapper.MedicoMapper;
import com.api.tcc.core.model.Medico;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
		
	public Medico save(Medico model) throws Exception {
		
		return MedicoMapper.converterDTO(repository.save(MedicoMapper.converterEntity(model)));
	}
	
	public List<Medico> getAll(){
		return MedicoMapper.converterListaDTO(repository.findAll());
	}
	
	public Medico getId(String id){
		return MedicoMapper.converterDTO(repository.findById(id).orElse(null));
	}
	
}

package com.api.tcc.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tcc.adapter.PacienteRepository;
import com.api.tcc.adapter.mapper.PacienteMapper;
import com.api.tcc.core.model.Paciente;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repository;
		
	public Paciente save(Paciente model) throws Exception {
		
		return PacienteMapper.converterDTO(repository.save(PacienteMapper.converterEntity(model)));
	}
	
	public List<Paciente> getAll(){
		return PacienteMapper.converterListaDTO(repository.findAll());
	}
	
	public Paciente getId(String id){
		return PacienteMapper.converterDTO(repository.findById(id).orElse(null));
	}

}

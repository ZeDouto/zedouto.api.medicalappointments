package com.api.tcc.core.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tcc.adapter.ConsultaRepository;
import com.api.tcc.adapter.entity.ConsultaEntity;
import com.api.tcc.adapter.mapper.ConsultaMapper;
import com.api.tcc.adapter.mapper.MedicoMapper;
import com.api.tcc.adapter.mapper.PacienteMapper;
import com.api.tcc.core.model.Consulta;
import com.api.tcc.core.model.Medico;
import com.api.tcc.core.model.Paciente;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;
		
	public Consulta save(Consulta model) throws Exception {
		model.setId(UUID.randomUUID().toString().toUpperCase());
		return ConsultaMapper.converterDTO(repository.save(ConsultaMapper.converterEntity(model)));
	}
	
	public List<Consulta> getAll() {
		return ConsultaMapper.converterListaDTO(repository.findAll());
	}
	
	public Consulta getId(String id) {
		return ConsultaMapper.converterDTO(repository.findById(id).orElse(new ConsultaEntity()));
	}

	public List<Consulta> getByPaciente(String cpf) {
		Paciente paciente = new Paciente();
		paciente.setCpf(cpf);

		return ConsultaMapper.converterListaDTO(repository.findByPaciente(PacienteMapper.converterEntity(paciente)).orElse(null));
	}
	
	public List<Consulta> getByMedico(Integer crm) {
		Medico medico = new Medico();
		medico.setCrm(crm);
		
		return ConsultaMapper.converterListaDTO(repository.findByMedico(MedicoMapper.converterEntity(medico)).orElse(null));
	}
}

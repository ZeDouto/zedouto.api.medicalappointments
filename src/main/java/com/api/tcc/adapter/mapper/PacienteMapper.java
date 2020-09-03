package com.api.tcc.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.tcc.adapter.entity.PacienteEntity;
import com.api.tcc.core.model.Paciente;

public class PacienteMapper {

	@Autowired
	private static ModelMapper modelMapper = new ModelMapper();

	public static List<Paciente> converterListaDTO(List<PacienteEntity> entities) {
		return entities.stream().map(entity -> converterDTO(entity)).collect(Collectors.toList());
	}

	public static List<PacienteEntity> converterListaEntity(List<Paciente> models) {
		return models.stream().map(model -> converterEntity(model)).collect(Collectors.toList());
	}

	public static Paciente converterDTO(PacienteEntity entity) {
		return modelMapper.map(entity, Paciente.class);
	}

	public static PacienteEntity converterEntity(Paciente model) {
		return modelMapper.map(model, PacienteEntity.class);
	}
}

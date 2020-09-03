package com.api.tcc.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.tcc.adapter.entity.MedicoEntity;
import com.api.tcc.core.model.Medico;

public class MedicoMapper {

	@Autowired
	private static ModelMapper modelMapper = new ModelMapper();

	public static List<Medico> converterListaDTO(List<MedicoEntity> entities) {
		return entities.stream().map(entity -> converterDTO(entity)).collect(Collectors.toList());
	}

	public static List<MedicoEntity> converterListaEntity(List<Medico> models) {
		return models.stream().map(model -> converterEntity(model)).collect(Collectors.toList());
	}

	public static Medico converterDTO(MedicoEntity entity) {
		return modelMapper.map(entity, Medico.class);
	}

	public static MedicoEntity converterEntity(Medico model) {
		return modelMapper.map(model, MedicoEntity.class);
	}

}

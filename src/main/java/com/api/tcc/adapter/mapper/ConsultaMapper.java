package com.api.tcc.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.tcc.adapter.entity.ConsultaEntity;
import com.api.tcc.core.model.Consulta;

public class ConsultaMapper {

	@Autowired
	private static ModelMapper modelMapper = new ModelMapper();

	public static List<Consulta> converterListaDTO(List<ConsultaEntity> entities) {
		return entities.stream().map(entity -> converterDTO(entity)).collect(Collectors.toList());
	}

	public static List<ConsultaEntity> converterListaEntity(List<Consulta> models) {
		return models.stream().map(model -> converterEntity(model)).collect(Collectors.toList());
	}

	public static Consulta converterDTO(ConsultaEntity entity) {
		return modelMapper.map(entity, Consulta.class);
	}

	public static ConsultaEntity converterEntity(Consulta model) {
		return modelMapper.map(model, ConsultaEntity.class);
	}
}

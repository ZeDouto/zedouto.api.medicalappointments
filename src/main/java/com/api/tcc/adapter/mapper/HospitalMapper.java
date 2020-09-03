package com.api.tcc.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.tcc.adapter.entity.HospitalEntity;
import com.api.tcc.core.model.Hospital;

public class HospitalMapper {

	@Autowired
	private static ModelMapper modelMapper = new ModelMapper();

	public static List<Hospital> converterListaDTO(List<HospitalEntity> entities) {
		return entities.stream().map(entity -> converterDTO(entity)).collect(Collectors.toList());
	}

	public static List<HospitalEntity> converterListaEntity(List<Hospital> models) {
		return models.stream().map(model -> converterEntity(model)).collect(Collectors.toList());
	}

	public static Hospital converterDTO(HospitalEntity entity) {
		return modelMapper.map(entity, Hospital.class);
	}

	public static HospitalEntity converterEntity(Hospital model) {
		return modelMapper.map(model, HospitalEntity.class);
	}
}

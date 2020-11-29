package com.api.tcc.adapter.mapper;

import com.api.tcc.adapter.entity.HospitalEntity;
import com.api.tcc.adapter.entity.HospitalMedicoEntity;
import com.api.tcc.core.model.Hospital;
import com.api.tcc.core.model.HospitalMedico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalMedicoMapper {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();

    public static List<HospitalMedico> converterListaDTO(List<HospitalMedicoEntity> entities) {
        return entities.stream().map(entity -> converterDTO(entity)).collect(Collectors.toList());
    }

    public static List<HospitalMedicoEntity> converterListaEntity(List<HospitalMedico> models) {
        return models.stream().map(model -> converterEntity(model)).collect(Collectors.toList());
    }

    public static HospitalMedico converterDTO(HospitalMedicoEntity entity) {
        return modelMapper.map(entity, HospitalMedico.class);
    }

    public static HospitalMedicoEntity converterEntity(HospitalMedico model) {
        return modelMapper.map(model, HospitalMedicoEntity.class);
    }
}

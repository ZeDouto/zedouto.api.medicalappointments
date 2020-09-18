package com.api.tcc.adapter.mapper;

import com.api.tcc.adapter.entity.HospitalEntity;
import com.api.tcc.adapter.entity.UsuarioEntity;
import com.api.tcc.core.model.Hospital;
import com.api.tcc.core.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();

    public static List<Usuario> converterListaDTO(List<UsuarioEntity> entities) {
        return entities.stream().map(entity -> converterDTO(entity)).collect(Collectors.toList());
    }

    public static List<UsuarioEntity> converterListaEntity(List<Usuario> models) {
        return models.stream().map(model -> converterEntity(model)).collect(Collectors.toList());
    }

    public static Usuario converterDTO(UsuarioEntity entity) {
        return modelMapper.map(entity, Usuario.class);
    }

    public static UsuarioEntity converterEntity(Usuario model) {
        return modelMapper.map(model, UsuarioEntity.class);
    }
}

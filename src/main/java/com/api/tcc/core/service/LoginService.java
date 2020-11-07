package com.api.tcc.core.service;

import com.api.tcc.adapter.LoginRepository;
import com.api.tcc.adapter.entity.UsuarioEntity;
import com.api.tcc.adapter.mapper.UsuarioMapper;
import com.api.tcc.core.model.Usuario;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService  {

    @Autowired
    private LoginRepository repository;

    public Usuario save(Usuario model){
        return UsuarioMapper.converterDTO(repository.save(UsuarioMapper.converterEntity(model)));
    }

    public Usuario get(Usuario model) throws NotFoundException {
        Optional<UsuarioEntity> usuario = repository.findByCrmAndSenha(model.getCrm(), model.getSenha());

        if(usuario.isPresent()){
        	UsuarioEntity encontrado = usuario.get();
            return Usuario.builder().nome(encontrado.getNome()).crm(encontrado.getCrm()).build();
        }

        throw new NotFoundException("Usuário não foi encontrado");
    }
}

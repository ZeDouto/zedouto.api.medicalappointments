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

    public Usuario get(String crm, String senha) throws NotFoundException {
        Optional<UsuarioEntity> usuario = repository.findByCrmAndSenha(crm, senha);

        if(usuario.isPresent()){
            return UsuarioMapper.converterDTO(usuario.get());
        }

        throw new NotFoundException("Usuário não foi encontrado");
    }
}
package com.api.tcc.adapter;

import com.api.tcc.adapter.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<UsuarioEntity, String> {
    Optional<UsuarioEntity> findByCrmAndSenha(String crm, String senha);
}
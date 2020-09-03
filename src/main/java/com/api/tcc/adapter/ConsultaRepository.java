package com.api.tcc.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tcc.adapter.entity.ConsultaEntity;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, String> {

}

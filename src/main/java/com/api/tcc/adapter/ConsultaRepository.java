package com.api.tcc.adapter;

import com.api.tcc.adapter.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tcc.adapter.entity.ConsultaEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, String> {
	Optional<List<ConsultaEntity>> findByPaciente(PacienteEntity paciente);
}

package com.api.tcc.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tcc.adapter.entity.ConsultaEntity;
import com.api.tcc.adapter.entity.MedicoEntity;
import com.api.tcc.adapter.entity.PacienteEntity;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, String> {
	Optional<List<ConsultaEntity>> findByPaciente(PacienteEntity paciente);
	
	Optional<List<ConsultaEntity>> findByMedico(MedicoEntity medico);
	
}

package com.api.tcc.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tcc.adapter.entity.HospitalEntity;
import com.api.tcc.core.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, String> {
	
	Optional<List<HospitalEntity>> findByCep(String cep);
}

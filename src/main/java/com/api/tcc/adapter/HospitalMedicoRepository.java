package com.api.tcc.adapter;

import com.api.tcc.adapter.entity.HospitalEntity;
import com.api.tcc.adapter.entity.HospitalMedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalMedicoRepository extends JpaRepository<HospitalMedicoEntity, String> {
    List<HospitalMedicoEntity> findByHospital(HospitalEntity hospital);
}

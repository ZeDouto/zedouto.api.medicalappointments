package com.api.tcc.core.service;

import com.api.tcc.adapter.HospitalMedicoRepository;
import com.api.tcc.adapter.entity.HospitalEntity;
import com.api.tcc.adapter.mapper.HospitalMedicoMapper;
import com.api.tcc.core.model.HospitalMedico;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HospitalMedicoService {

    @Autowired
    private HospitalMedicoRepository repository;

    public List<HospitalMedico> save(List<HospitalMedico> hospitalMedicos) {
        return HospitalMedicoMapper.converterListaDTO(repository.saveAll(HospitalMedicoMapper.converterListaEntity(hospitalMedicos)));
    }

    public List<HospitalMedico> getByHospital(String hospitalId) {
        HospitalEntity hospital = new HospitalEntity();
        hospital.setId(hospitalId);

        return HospitalMedicoMapper.converterListaDTO(repository.findByHospital(hospital));
    }
}

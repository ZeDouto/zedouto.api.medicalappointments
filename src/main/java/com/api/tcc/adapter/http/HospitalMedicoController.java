package com.api.tcc.adapter.http;

import java.util.List;

import javax.validation.Valid;

import com.api.tcc.core.model.HospitalMedico;
import com.api.tcc.core.service.HospitalMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tcc.adapter.http.routes.Routes;
import com.api.tcc.core.model.Hospital;
import com.api.tcc.core.service.HospitalService;

@RestController
@RequestMapping(Routes.ROUTE_HOSPITAL_MEDICO)
@Validated
public class HospitalMedicoController {

    @Autowired
    private HospitalMedicoService service;

    @GetMapping(value = Routes.PATH_HOSPITAL_ID)
    public ResponseEntity<List<HospitalMedico>> getHospital(@PathVariable(name = "hospitalId") String id) {
        return new ResponseEntity<>(service.getByHospital(id), HttpStatus.OK);
    }
}

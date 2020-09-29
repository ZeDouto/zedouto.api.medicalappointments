package com.api.tcc.adapter.http;

import java.util.List;

import javax.validation.Valid;

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
@RequestMapping(Routes.ROUTE_HOSPITAL)
@Validated
public class HospitalController {

	@Autowired
	private HospitalService service;

	@PostMapping
	public ResponseEntity<Hospital> post(@Valid @RequestBody Hospital model) throws Exception {
		return new ResponseEntity<>(service.save(model), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Hospital>> get() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = Routes.PATH_CEP)
	public ResponseEntity<List<Hospital>> getId(@PathVariable(name = "cep") String cep) {
		return new ResponseEntity<>(service.getByCep(cep), HttpStatus.OK);
	}
}

package com.api.tcc.adapter.http;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tcc.adapter.http.routes.Routes;
import com.api.tcc.core.model.Medico;
import com.api.tcc.core.service.MedicoService;

@RestController
@RequestMapping(Routes.ROUTE_MEDICO)
public class MedicoController {

	@Autowired
	private MedicoService service;

	@PostMapping
	public ResponseEntity<Medico> post(@Valid @RequestBody Medico model) throws Exception {
		return new ResponseEntity<>(service.save(model), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Medico>> get() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
}

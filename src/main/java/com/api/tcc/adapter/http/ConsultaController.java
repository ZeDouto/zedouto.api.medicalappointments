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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.tcc.adapter.http.routes.Routes;
import com.api.tcc.core.model.Consulta;
import com.api.tcc.core.service.ConsultaService;

@RestController
@RequestMapping(Routes.ROUTE_CONSULTA)
@Validated
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	@PostMapping
	public ResponseEntity<Consulta> post(@Valid @RequestBody Consulta model) throws Exception {
		return new ResponseEntity<>(service.save(model), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Consulta>> get() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = Routes.PATH_ID)
	public ResponseEntity<Consulta> getId(@PathVariable(name = "id") String id) {
		return new ResponseEntity<>(service.getId(id), HttpStatus.OK);
	}

	@GetMapping(value = Routes.PATH_CONSULTA_BY_PACIENTE)
	public ResponseEntity<List<Consulta>> getByPaciente(@PathVariable(name = "cpf") String cpf) {
		return new ResponseEntity<>(service.getByPaciente(cpf), HttpStatus.OK);
	}

	@GetMapping(value = Routes.PATH_CONSULTA_BY_MEDICO)
	public ResponseEntity<List<Consulta>> getByMedico(@PathVariable(name = "cpf") Integer cpf) {
		return new ResponseEntity<>(service.getByMedico(cpf), HttpStatus.OK);
	}
}

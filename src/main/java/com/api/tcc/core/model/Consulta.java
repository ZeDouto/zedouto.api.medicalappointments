package com.api.tcc.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = -4777023947908097374L;
	
	private String id;
		
	private Medico medico;
	
	private Paciente paciente;
	
	private Hospital hospital;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data;

	private String sintomasApresentados;
	
	private String examesRealizados;
}

package com.api.tcc.core.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

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
public class Paciente implements Serializable{
	
	private static final long serialVersionUID = -4777023947908097374L;

	private static final String NOT_NULL = "CAMPO NÃO PODE SER NULO";

	@NotNull(message = NOT_NULL)
	@CPF
	private String cpf;

	@NotNull(message = NOT_NULL)
	private String nome;
	
}

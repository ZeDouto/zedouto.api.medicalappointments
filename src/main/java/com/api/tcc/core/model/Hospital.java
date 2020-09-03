package com.api.tcc.core.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Hospital implements Serializable {

	private static final long serialVersionUID = -4777023947908097374L;
	
	private static final String NOT_NULL = "CAMPO NÃO PODE SER NULO";
	
	private String id;	
	
	@NotNull(message = NOT_NULL)
	private String cidade;
	
	@NotNull(message = NOT_NULL)
	@Size(max = 2, min = 2)
	private String estado;
	
	@NotNull(message = NOT_NULL)
	private String logradouro;
	
	@NotNull(message = NOT_NULL)
	private Integer numero;
	
	@NotNull(message = NOT_NULL)
	@Size(max = 8, min = 8)
	private String cep;
	
	private String nomeFantasia;
}

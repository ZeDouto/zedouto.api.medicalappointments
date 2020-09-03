package com.api.tcc.adapter.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TABELA_MEDICO")
public class MedicoEntity implements Serializable {
	
	private static final long serialVersionUID = -4777023947908097374L;

	@Id
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ESPECIALIDADE")
	private String especialidade;
	
	@Column(name = "CRM", unique = true)
	private Integer crm;
	
	@OneToMany(mappedBy = "medico")
	private Set<ConsultaEntity> consultas;
}

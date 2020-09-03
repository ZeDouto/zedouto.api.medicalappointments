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
@Table(name = "TABELA_HOSPITAL")
public class HospitalEntity implements Serializable {
	
	private static final long serialVersionUID = -4777023947908097374L;
	
	@Id
	@Column(name = "id")
	private String id;	
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO")
	private Integer numero;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	
	@OneToMany(mappedBy = "hospital")
	private Set<ConsultaEntity> consultas;
}

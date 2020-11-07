package com.api.tcc.adapter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TABELA_CONSULTA")
public class ConsultaEntity implements Serializable {
	
	private static final long serialVersionUID = -4777023947908097374L;
	
	@Id
	@Column(name = "id")
	private String id;
		
	@ManyToOne
	@JoinColumn(name = "MEDICO")
	private MedicoEntity medico;
	
	@ManyToOne
	@JoinColumn(name = "PACIENTE")
	private PacienteEntity paciente;
	
	@ManyToOne
	@JoinColumn(name = "HOSPITAL")
	private HospitalEntity hospital;
	
	@Column(name = "DATA")
	private Date data;
	
	@Column(name = "SINTOMAS_APRESENTADOS")
	private String sintomasApresentados;
	
	@Column(name = "EXAMES_REALIZADOS")
	private String examesRealizados;
	
	@Column(name = "RECEITA")
	private String receita;
}

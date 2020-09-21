package com.api.tcc.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TABELA_USUARIO")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = -4777023947908097374L;

    @Id
    @Column(name = "CRM")
    private String crm;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SENHA")
    private String senha;
}
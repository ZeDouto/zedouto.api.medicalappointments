package com.api.tcc.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TABELA_MEDICO_HOSPITAL")
public class HospitalMedicoEntity implements Serializable {

    private static final long serialVersionUID = -4777023947908097374L;

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "HOSPITAL")
    private HospitalEntity hospital;

    @Column(name = "MEDICO")
    private String medico;
}

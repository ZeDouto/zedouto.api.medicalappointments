package com.api.tcc.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalMedico implements Serializable {

    private static final long serialVersionUID = -4777023947908097374L;

    private static final String NOT_NULL = "CAMPO NÃO PODE SER NULO";

    private int id;

    private Hospital hospital;

    private String Medico;
}

package com.api.tcc.adapter.http.routes;

public class Routes {
	
	public static final String CONTEXTO_API = "dashboard/v1";
	public static final String ROUTE_MEDICO = CONTEXTO_API + "/medicos";
	public static final String ROUTE_PACIENTE = CONTEXTO_API + "/pacientes";
	public static final String ROUTE_HOSPITAL = CONTEXTO_API + "/hospitais";
	public static final String ROUTE_CONSULTA = CONTEXTO_API + "/consultas";
	public static final String ROUTE_HEALTH_CHECK = CONTEXTO_API + "/healthz";
	public static final String ROUTE_LOGIN = CONTEXTO_API + "/login";
	
	public static final String PATH_ID = "/{id}";
	public static final String PATH_CEP = "/{cep}";
	public static final String PATH_CPF = "/{cpf}";

}

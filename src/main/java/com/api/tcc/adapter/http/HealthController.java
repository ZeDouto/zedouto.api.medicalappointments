package com.api.tcc.adapter.http;

import com.api.tcc.adapter.http.routes.Routes;
import com.api.tcc.core.model.Consulta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.ROUTE_HEALTH_CHECK)
public class HealthController {
    @GetMapping
    public ResponseEntity<String> get() {
        return new ResponseEntity<String>("Tudo funcionando!", HttpStatus.OK);
    }
}

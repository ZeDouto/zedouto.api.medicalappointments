package com.api.tcc.adapter.http;

import com.api.tcc.core.model.Usuario;
import com.api.tcc.core.service.LoginService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.tcc.adapter.http.routes.Routes;

import javax.validation.Valid;

@RestController
@RequestMapping(Routes.ROUTE_LOGIN)
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Usuario> login(@RequestParam(name = "crm") String crm, @RequestParam(name = "senha") String senha) throws NotFoundException {
        return new ResponseEntity<>(service.get(crm, senha), HttpStatus.OK);
    }
}

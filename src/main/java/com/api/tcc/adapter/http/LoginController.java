package com.api.tcc.adapter.http;

import com.api.tcc.adapter.http.routes.Routes;
import com.api.tcc.core.model.Usuario;
import com.api.tcc.core.service.LoginService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.ROUTE_LOGIN)
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping(value = Routes.PATH_CADASTRO)
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario)throws NotFoundException, NotFoundException {
        return new ResponseEntity<>(service.get(usuario), HttpStatus.OK);
    }
}

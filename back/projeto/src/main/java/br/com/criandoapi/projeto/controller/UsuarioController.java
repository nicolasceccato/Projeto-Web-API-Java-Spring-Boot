package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.dao.UsuarioDAO;
import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO dao;

    @GetMapping("/usuarios")
    public List<Usuario> listaDeUsuarios() {
        return (List<Usuario>) dao.findAll();
    }


}

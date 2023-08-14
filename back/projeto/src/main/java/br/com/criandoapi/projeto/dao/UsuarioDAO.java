package br.com.criandoapi.projeto.dao;

import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
}

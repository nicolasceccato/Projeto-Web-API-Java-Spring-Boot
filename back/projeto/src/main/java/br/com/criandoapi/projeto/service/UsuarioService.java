package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.dto.UsuarioDTO;
import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.repository.UsuarioDAO;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.security.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    private final UsuarioDAO repository;
    private final PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(UsuarioDAO repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario() {
        logger.info("Usuario: " + getLogado() + " Listando usuarios");
        return repository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        logger.info("Usuario: " + getLogado() + " Criando usuarios");
        return repository.save(usuario);
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        logger.info("Usuario: " + getLogado() + " Editando usuario " + usuario.getNome());
        return repository.save(usuario);
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        logger.info("Usuario: " + getLogado() + " Excluindo usuario");
        return true;
    }

    public Token gerarToken(UsuarioDTO usuario) {
        Usuario user = repository.findByNomeOrEmail(usuario.getNome(), usuario.getEmail());
        if (user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if (valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }

    private String getLogado() {
        Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
        if (!(userLogado instanceof AnonymousAuthenticationToken)) {
            return userLogado.getName();
        }
        return "Null";
    }
}

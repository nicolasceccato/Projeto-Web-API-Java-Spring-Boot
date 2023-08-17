package br.com.criandoapi.projeto.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome_completo", length = 200, nullable = true)
    private String nome;
    @Column(name = "username", length = 100, nullable = true, unique = true)
    private String username;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;
    @Column(name = "telefone", length = 15, nullable = true)
    private String telefone;


}

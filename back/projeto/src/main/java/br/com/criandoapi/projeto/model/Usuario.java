package br.com.criandoapi.projeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, max = 200, message = "O nome deve ter no mínimo 3 e no máximo 200 caracteres!")
    @Column(name = "nome_completo", length = 200, nullable = false)
    private String nome;

    @NotBlank(message = "O username é obrigatório!")
    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Email(message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email", length = 50)
    private String email;

    @NotBlank(message = "É necessário definir uma senha!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "É necessário definir informar um telefone!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

}

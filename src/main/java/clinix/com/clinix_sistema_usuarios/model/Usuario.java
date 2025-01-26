package clinix.com.clinix_sistema_usuarios.model;

import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Column(unique = true, nullable = false)
    private String nome;

    @NotBlank(message = "O nome de usuário é obrigatório.")
    @Column(unique = true, nullable = false)
    private String nomeUsuario;

    @Email(message = "Por favor, insira um email válido.")
    @NotBlank(message = "O email é obrigatório.")
    @Column(unique = true, nullable = false)
    private String email;

    @Size(max = 60)
    @NotBlank(message = "A senha é obrigatória e não pode estar vazia.")
    private String senha;

    public abstract void atualizar(Usuario outroUsuario);


}

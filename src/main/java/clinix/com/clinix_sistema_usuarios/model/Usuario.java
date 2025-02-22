package clinix.com.clinix_sistema_usuarios.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // Define a herança como SINGLE_TABLE
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)  // Define a coluna discriminadora
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O nome de usuário é obrigatório.")
    private String nomeUsuario;

    private String CPF;

    private String RG;

    private boolean enabled = true;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataCadastro;

    @Email(message = "Por favor, insira um email válido.")
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @Size(max = 60)
    @NotBlank(message = "A senha é obrigatória e não pode estar vazia.")
    private String senha;

    public Usuario(String nome, String nomeUsuario, String email, String senha, String cpf, String rg) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = new Date();
        this.enabled = true;
        this.CPF = cpf;
        this.RG = rg;
    }

    public abstract void atualizar(Usuario outroUsuario);

    public void bloquear() {
        this.enabled = false;
    }

    public void desbloquear() {
        this.enabled = true;
    }

    public boolean isNull(){
        return false;   
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getRG() {
        return this.RG;
    }

}

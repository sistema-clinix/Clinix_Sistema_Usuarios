package clinix.com.clinix_sistema_usuarios.model;

import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O nome de usuário é obrigatório.")
    //@Column(unique = true, nullable = false)
    private String nomeUsuario;

    private String CPF;

    private String RG;

    private boolean enabled = true;
    private Date dataCadastro;

    @Email(message = "Por favor, insira um email válido.")
    @NotBlank(message = "O email é obrigatório.")
    //@Column(unique = true, nullable = false)
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

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return CPF;
    }

    public void setCpf(String cpf) {
        this.CPF = cpf;
    }

    public String getRg() {
        return RG;
    }

    public void setRg(String rg) {
        this.RG = rg;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isNull(){
        return false;   
    }

}

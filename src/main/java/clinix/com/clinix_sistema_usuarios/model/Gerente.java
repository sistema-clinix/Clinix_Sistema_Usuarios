package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gerente implements Serializable {

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

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime dataCadastro;

    @Email(message = "Por favor, insira um email válido.")
    @NotBlank(message = "O email é obrigatório.")
    //@Column(unique = true, nullable = false)
    private String email;

    @Size(max = 60)
    @NotBlank(message = "A senha é obrigatória e não pode estar vazia.")
    private String senha;

    @ElementCollection
    @CollectionTable(name = "gerencias", joinColumns = @JoinColumn(name = "gerente_id"))
    @Column(name = "clinica_id")
    private List<Long> clinicas = new ArrayList<>();
    

    public boolean cadastrarClinica(Long c_id){
        if (this.clinicas.contains(c_id)) return false;
        return clinicas.add(c_id);
    }
    
    public boolean removerClinica( Long c_id){
        if (!this.clinicas.contains(c_id)) return false;
        return clinicas.remove(c_id);
    }

    public List<Long> listarClinicas(){
        return new ArrayList<>(this.clinicas);
    }

    public boolean isNull(){
        return false;   
    }
}
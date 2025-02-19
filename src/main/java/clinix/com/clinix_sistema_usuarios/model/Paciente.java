package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "tb_paciente")
public class Paciente extends Usuario implements Serializable {

    public Paciente(String nome, String nomeUsuario, String email, String senha, String cpf, String rg) {
        super(nome, nomeUsuario, email, senha, cpf, rg);
    }

    public Paciente() {
        super("", "", "", "","","");
    }

    @Override
    public void atualizar(Usuario outroUsuario) {
    }
}

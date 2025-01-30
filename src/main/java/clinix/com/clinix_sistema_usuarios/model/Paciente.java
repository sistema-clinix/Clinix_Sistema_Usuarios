package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_paciente")
public class Paciente extends Usuario {

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

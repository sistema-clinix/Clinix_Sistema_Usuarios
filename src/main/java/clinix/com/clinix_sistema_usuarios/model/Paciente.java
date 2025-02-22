package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue("PACIENTE")  
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

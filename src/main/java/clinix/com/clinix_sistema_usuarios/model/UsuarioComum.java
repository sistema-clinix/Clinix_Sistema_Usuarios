package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario_comum")
public class UsuarioComum extends Usuario{

    private String CPF;
    private String RG;

    @Getter
    private boolean enabled = true;
    private Date dataCadastro;

    public UsuarioComum() {
        super();
    }

    public void bloquear() {
        this.enabled = false;
    }

    public void desbloquear() {
        this.enabled = true;
    }

    @Override
    public void atualizar(Usuario outroUsuario) {
    }
}

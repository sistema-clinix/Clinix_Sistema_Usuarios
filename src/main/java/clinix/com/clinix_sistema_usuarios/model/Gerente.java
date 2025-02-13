package clinix.com.clinix_sistema_usuarios.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_gerente")
@Data
public class Gerente extends Usuario {
    
    @ElementCollection
    @CollectionTable(name = "tb_gerente_clinica", joinColumns = @JoinColumn(name = "g_id"))
    @Column(name= "clinica_id")
    private List<Long> clinicas_id = new ArrayList<>();

    public Gerente(String nome, String nomeUsuario, String email, String senha, String cpf, String rg) {
        super(nome, nomeUsuario, email, senha, cpf, rg);
    }

    public Gerente() {
        super("", "", "", "","","");
    }

    @Override
    public void atualizar(Usuario outroUsuario) {
        if (outroUsuario instanceof Gerente outroGerente) {
            this.setNome(outroGerente.getNome());
            this.setNomeUsuario(outroGerente.getNomeUsuario());
            this.setEmail(outroGerente.getEmail());
            this.setSenha(outroGerente.getSenha());
            this.setCpf(outroGerente.getCpf());
            this.setRg(outroGerente.getRg());
        }
    }
    
    public boolean cadastrarClinica(Long c_id){
        if (this.clinicas_id.contains(c_id)) return false;
        return clinicas_id.add(c_id);
    }
    
    public boolean removerClinica( Long c_id){
        if (!this.clinicas_id.contains(c_id)) return false;
        return clinicas_id.remove(c_id);
    }

    public List<Long> listarClinicas(){
        return new ArrayList<>(this.clinicas_id);
    }
}

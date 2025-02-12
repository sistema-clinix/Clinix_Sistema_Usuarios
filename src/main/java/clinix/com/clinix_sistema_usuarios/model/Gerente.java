package clinix.com.clinix_sistema_usuarios.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_gerente")
public class Gerente extends Usuario {

    //@OneToMany(mappedBy = "gerente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Clinica> clinicas = new ArrayList<>();

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
    /*
    public void cadastrarClinica(Clinica clinica) {
        if (!clinicas.contains(clinica)) {
            clinicas.add(clinica);
            //clinica.setGerente(this);
            System.out.println("Clínica cadastrada com sucesso: " + clinica.getNomeFantasia());
        } else {
            System.out.println("A clínica já está cadastrada.");
        }
    }

    public void removerClinica(Clinica clinica) {
        if (clinicas.contains(clinica)) {
            clinicas.remove(clinica);
            //clinica.setGerente(null);
            System.out.println("Clínica removida com sucesso: " + clinica.getNomeFantasia());
        } else {
            System.out.println("A clínica não está cadastrada.");
        }
    }

    // Getters e Setters
    public  List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }
    */
}

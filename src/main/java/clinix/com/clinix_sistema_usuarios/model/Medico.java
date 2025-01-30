package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "tb_medico")
public class Medico extends Usuario{
    //private List<Clinica> clinicasVinculadas;
    //private Especialidade especialidade;
    //private List<Agendamento> consultasAgendadas;
    //private List<Consulta> consultasRealizadas;

    @Getter
    @Setter
    private String crm;

    @Getter
    @Setter
    private Time inicioAtendimento;

    @Getter
    @Setter
    private Time finalAtendimento;


    public Medico(String nome, String nomeUsuario, String email, String senha, String cpf, String rg,
                  String crm, Time inicioAtendimento, Time finalAtendimento) {
        super(nome, nomeUsuario, email, senha, cpf, rg);

        this.crm = crm;
        this.inicioAtendimento = inicioAtendimento;
        this.finalAtendimento = finalAtendimento;
    }

    public Medico() {
        super("", "", "", "","","");
    }

    /*
    public Medico(String nome, String nomeUsuario, String email, String senha, Especialidade especialidade, String crm,
                  Time inicioAtendimento, Time finalAtendimento) {
        super(nome, nomeUsuario, email, senha);
        this.clinicasVinculadas = new ArrayList<>();
        this.consultasAgendadas = new ArrayList<>();
        this.consultasRealizadas = new ArrayList<>();
        this.especialidade = especialidade;
        this.crm = crm;
        this.inicioAtendimento = inicioAtendimento;
        this.finalAtendimento = finalAtendimento;
    }

    public List<Agendamento> visualizarAgendamentos() {
        return new ArrayList<>(consultasAgendadas);
    }

    public void cancelarAgendamento(Agendamento agendamento) {
        consultasAgendadas.remove(agendamento);
    }

    public void atualizarAtendimento(Time inicio, Time fim) {
        this.inicioAtendimento = inicio;
        this.finalAtendimento = fim;
    }

    public void vincularClinica(Clinica clinica) {
        if (!clinicasVinculadas.contains(clinica)) {
            clinicasVinculadas.add(clinica);
        }
    }

    public void desvincularClinica(Clinica clinica) {
        clinicasVinculadas.remove(clinica);
    }

    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultasRealizadas);
    }

    public void confirmarAgendamento(Agendamento agendamento) {
        if (consultasAgendadas.contains(agendamento)) {
            consultasAgendadas.remove(agendamento);
            consultasRealizadas.add(new Consulta(agendamento));
        }
    }

    // Getters e Setters
    public List<Clinica> getClinicasVinculadas() {
        return clinicasVinculadas;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    */

    @Override
    public void atualizar(Usuario outroUsuario) {

    }
}

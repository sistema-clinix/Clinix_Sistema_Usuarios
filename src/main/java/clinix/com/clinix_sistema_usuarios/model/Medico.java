package clinix.com.clinix_sistema_usuarios.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "tb_medico")
public class Medico extends Usuario{
    
    @ElementCollection
    @CollectionTable(name = "tb_medico_clinica", joinColumns = @JoinColumn(name = "m_id"))
    @Column(name= "c_id")
    private List<Long> clinicas_id = new ArrayList<>();


    //private List<Agendamento> consultasAgendadas;
    //private List<Consulta> consultasRealizadas;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioAtendimento> horariosAtendimento = new ArrayList<>();

    private String crm;

    private Time inicioAtendimento;

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

s e Setters
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

    public boolean vincular(Long c_id){
        if (this.clinicas_id.contains(c_id)) return false;
        return clinicas_id.add(c_id);
    }
    
    public boolean desvincular( Long c_id){
        if (!this.clinicas_id.contains(c_id)) return false;
        return clinicas_id.remove(c_id);
    }

    public List<Long> listarClinicas(){
        return new ArrayList<>(this.clinicas_id);
    }
}

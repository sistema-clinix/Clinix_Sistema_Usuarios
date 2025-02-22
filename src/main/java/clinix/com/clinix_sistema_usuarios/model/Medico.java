package clinix.com.clinix_sistema_usuarios.model;

//import clinix.com.clinix_sistema_usuarios.dto.HorarioAtendimento;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MEDICO")  // Define o valor que será salvo na coluna 'tipo_usuario'
public class Medico extends Usuario implements Serializable {
    
    @ElementCollection
    @CollectionTable(name = "tb_medico_clinica", joinColumns = @JoinColumn(name = "m_id"))
    @Column(name= "c_id")
    private List<Long> clinicas_id = new ArrayList<>();


    //private List<Agendamento> consultasAgendadas;
    //private List<Consulta> consultasRealizadas;

    @ElementCollection
    @CollectionTable(name = "medico_horarios", joinColumns = @JoinColumn(name = "medico_id"))
    @Column(name = "horario_id")
    private List<Long> horariosAtendimento = new ArrayList<>();

    private String crm;

    private Time inicioAtendimento;

    private Time finalAtendimento;

    public Medico() {
        super("", "", "", "","","");
    }

//    public List<Agendamento> visualizarAgendamentos() {
//        return new ArrayList<>(consultasAgendadas);
//    }
//
//    public void cancelarAgendamento(Agendamento agendamento) {
//        consultasAgendadas.remove(agendamento);
//    }
//
//    public void atualizarAtendimento(Time inicio, Time fim) {
//        this.inicioAtendimento = inicio;
//        this.finalAtendimento = fim;
//    }
//
//    public void vincularClinica(Clinica clinica) {
//        if (!clinicasVinculadas.contains(clinica)) {
//            clinicasVinculadas.add(clinica);
//        }
//    }
//
//    public void desvincularClinica(Clinica clinica) {
//        clinicasVinculadas.remove(clinica);
//    }
//
//    public List<Consulta> listarConsultas() {
//        return new ArrayList<>(consultasRealizadas);
//    }
//
//    public void confirmarAgendamento(Agendamento agendamento) {
//        if (consultasAgendadas.contains(agendamento)) {
//            consultasAgendadas.remove(agendamento);
//            consultasRealizadas.add(new Consulta(agendamento));
//        }
//    }
//
//s e Setters
//    public List<Clinica> getClinicasVinculadas() {
//        return clinicasVinculadas;
//    }
//
//    public Especialidade getEspecialidade() {
//        return especialidade;
//    }
//
//    public void setEspecialidade(Especialidade especialidade) {
//        this.especialidade = especialidade;
//    }
//    */
//
    @Override
    public void atualizar(Usuario outroUsuario) {
    }
//
//    public boolean vincular(Long c_id){
//        if (this.clinicas_id.contains(c_id)) return false;
//        return clinicas_id.add(c_id);
//    }
//
//    public boolean desvincular( Long c_id){
//        if (!this.clinicas_id.contains(c_id)) return false;
//        return clinicas_id.remove(c_id);
//    }
//
//    public List<Long> listarClinicas(){
//        return new ArrayList<>(this.clinicas_id);
//    }
}

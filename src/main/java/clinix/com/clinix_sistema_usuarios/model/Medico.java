package clinix.com.clinix_sistema_usuarios.model;

//import clinix.com.clinix_sistema_usuarios.dto.HorarioAtendimento;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Medico implements Serializable {

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

    private String crm;

    private String inicioAtendimento;

    private String finalAtendimento;

    @ElementCollection
    @CollectionTable(name = "vinculos", joinColumns = @JoinColumn(name = "m_id"))
    @Column(name = "c_id")
    private List<Long> clinicas_id = new ArrayList<>();

    // private List<Agendamento> consultasAgendadas;
    // private List<Consulta> consultasRealizadas;

    // @ElementCollection
    // @CollectionTable(name = "medico_horarios", joinColumns = @JoinColumn(name = "medico_id"))
    // @Column(name = "horario_id")
    // private List<Long> horariosAtendimento = new ArrayList<>();

    // public List<Agendamento> visualizarAgendamentos() {
    // return new ArrayList<>(consultasAgendadas);
    // }
    //
    // public void cancelarAgendamento(Agendamento agendamento) {
    // consultasAgendadas.remove(agendamento);
    // }
    //
    // public void atualizarAtendimento(Time inicio, Time fim) {
    // this.inicioAtendimento = inicio;
    // this.finalAtendimento = fim;
    // }
    //

    // TODO: Usar RMI para vincular e desvincular clinicas.

    // public void vincularClinica(Clinica clinica) {
    // if (!clinicasVinculadas.contains(clinica)) {
    // clinicasVinculadas.add(clinica);
    // }
    // }
    //
    // public void desvincularClinica(Clinica clinica) {
    // clinicasVinculadas.remove(clinica);
    // }
    //
    // public List<Consulta> listarConsultas() {
    // return new ArrayList<>(consultasRealizadas);
    // }
    //
    // public void confirmarAgendamento(Agendamento agendamento) {
    // if (consultasAgendadas.contains(agendamento)) {
    // consultasAgendadas.remove(agendamento);
    // consultasRealizadas.add(new Consulta(agendamento));
    // }
    // }
    //
    // public List<Clinica> getClinicasVinculadas() {
    // return clinicasVinculadas;
    // }
    //
    // public Especialidade getEspecialidade() {
    // return especialidade;
    // }
    //
    // public void setEspecialidade(Especialidade especialidade) {
    // this.especialidade = especialidade;
    // }
    // */
    //
    // @Override
    // public void atualizar(Usuario outroUsuario) {
    // }
    //
    // public boolean vincular(Long c_id){
    // if (this.clinicas_id.contains(c_id)) return false;
    // return clinicas_id.add(c_id);
    // }
    //
    // public boolean desvincular( Long c_id){
    // if (!this.clinicas_id.contains(c_id)) return false;
    // return clinicas_id.remove(c_id);
    // }
    //
    public List<Long> listarClinicas(){
    return new ArrayList<>(this.clinicas_id);
    }

    public boolean isNull() {
        return false;
    }
}

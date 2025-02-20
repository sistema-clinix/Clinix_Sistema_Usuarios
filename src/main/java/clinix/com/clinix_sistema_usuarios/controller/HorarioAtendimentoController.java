package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.HorarioAtendimento;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.service.HorarioAtendimentoService;
import clinix.com.clinix_sistema_usuarios.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class HorarioAtendimentoController {

    private final HorarioAtendimentoService horarioAtendimentoService;
    private final PacienteService pacienteService;

    @Autowired
    public HorarioAtendimentoController(HorarioAtendimentoService horarioAtendimentoService, PacienteService pacienteService) {
        this.horarioAtendimentoService = horarioAtendimentoService;
        this.pacienteService = pacienteService;
    }
    @GetMapping("/horarios")
    public List<HorarioAtendimento> listarHorarios() {
        return horarioAtendimentoService.listarHorarios();
    }

    @GetMapping("/list") //lista todos os horarios indisponíveis
    public List<HorarioAtendimento> listarHorariosIndisponiveis() {
        return horarioAtendimentoService.listarHorariosOcupados();
    }

    @GetMapping("/disponiveis/{medicoId}")
    public List<HorarioAtendimento> listarHorariosDisponiveis(@PathVariable Long medicoId) {
        return horarioAtendimentoService.listarHorariosDisponiveis(medicoId);
    }

    @GetMapping("/indisponiveis/{medicoId}") //lista todos os horários indisponíveis
    public List<HorarioAtendimento> listarHorariosIndisponiveis(@PathVariable Long medicoId) {
        return horarioAtendimentoService.listarHorariosIndisponiveis(medicoId);
    }

    @GetMapping("/listHorarios/{medicoId}")
    public List<HorarioAtendimento> listarTodosHorarios(@PathVariable Long medicoId) {
        return horarioAtendimentoService.listarTodosHorarios(medicoId);
    }

    @PostMapping("/save/{horarioId}/{pacienteId}")
    public HorarioAtendimento reservarHorario(@PathVariable Long horarioId, @PathVariable Long pacienteId) {
        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        return horarioAtendimentoService.reservarHorario(horarioId, paciente);
    }

    @DeleteMapping("/deletar/{horarioId}")
    public void excluirHorario(@PathVariable Long horarioId) {
        horarioAtendimentoService.excluirHorario(horarioId);
    }

}
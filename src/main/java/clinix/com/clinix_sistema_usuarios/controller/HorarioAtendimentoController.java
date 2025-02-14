package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.HorarioAtendimento;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.service.HorarioAtendimentoService;
import clinix.com.clinix_sistema_usuarios.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioAtendimentoController {

    private final HorarioAtendimentoService horarioAtendimentoService;
    private final PacienteService pacienteService;

    @Autowired
    public HorarioAtendimentoController(HorarioAtendimentoService horarioAtendimentoService, PacienteService pacienteService) {
        this.horarioAtendimentoService = horarioAtendimentoService;
        this.pacienteService = pacienteService;
    }
    @GetMapping("/")
    public List<HorarioAtendimento> listarHorarios() {
        return horarioAtendimentoService.listarHorarios();
    }
    @GetMapping("/disponiveis/{medicoId}")
    public List<HorarioAtendimento> listarHorariosDisponiveis(@PathVariable Long medicoId) {
        return horarioAtendimentoService.listarHorariosDisponiveis(medicoId);
    }

    @GetMapping("/indisponiveis/{medicoId}")
    public List<HorarioAtendimento> listarHorariosIndisponiveis(@PathVariable Long medicoId) {
        return horarioAtendimentoService.listarHorariosIndisponiveis(medicoId);
    }

    @GetMapping("/listHorarios/{medicoId}")
    public List<HorarioAtendimento> listarTodosHorarios(@PathVariable Long medicoId) {
        return horarioAtendimentoService.listarTodosHorarios(medicoId);
    }

    @PostMapping("/reservar/{horarioId}/{pacienteId}")
    public HorarioAtendimento reservarHorario(@PathVariable Long horarioId, @PathVariable Long pacienteId) {
        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        return horarioAtendimentoService.reservarHorario(horarioId, paciente);
    }

    @DeleteMapping("/delete/{horarioId}")
    public void excluirHorario(@PathVariable Long horarioId) {
        horarioAtendimentoService.excluirHorario(horarioId);
    }

}

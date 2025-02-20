package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.HorarioAtendimento;
import clinix.com.clinix_sistema_usuarios.model.Medico;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.repository.HorarioAtendimentoRepository;
import clinix.com.clinix_sistema_usuarios.service.MedicoService;
import clinix.com.clinix_sistema_usuarios.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private MedicoService medicoService;
    private final HorarioAtendimentoRepository horarioAtendimentoRepository;

    @Autowired
    public MedicoController(MedicoService medicoService, HorarioAtendimentoRepository horarioAtendimentoRepository) {

        this.medicoService = medicoService;
        this.horarioAtendimentoRepository = horarioAtendimentoRepository;
    }

    @GetMapping("/list")
    public List<Medico> listar() {
        return this.medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Medico buscar(@PathVariable Long id) {
        return this.medicoService.buscarPorId(id);
    }

    @PostMapping("/save")
    public Medico criar(@RequestBody Medico medico) {
        System.out.println("Recebendo médico: " + medico);
        return this.medicoService.salvar(medico);
    }

    @PutMapping("/atualizar/{id}")
    public Medico atualizar(@RequestBody Medico medico) {
        return this.medicoService.atualizar(medico);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        this.medicoService.deletar(id);
    }

    @PostMapping("/{id}/horarios")
    public ResponseEntity<String> adicionarHorarios(@PathVariable Long id, @RequestBody List<HorarioAtendimento> horarios) {
        Medico medico = medicoService.buscarPorId(id);
        if (medico == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado.");
        }

        for (HorarioAtendimento horario : horarios) {
            horario.setMedico(medico);
            horarioAtendimentoRepository.save(horario);
        }

        return ResponseEntity.ok("Horários adicionados com sucesso!");
    }
}
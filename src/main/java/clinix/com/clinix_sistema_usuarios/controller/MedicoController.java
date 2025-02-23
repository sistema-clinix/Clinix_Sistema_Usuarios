package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Medico;//import clinix.com.clinix_sistema_usuarios.repository.HorarioAtendimentoRepository;
import clinix.com.clinix_sistema_usuarios.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

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

    @PutMapping("/{id}")
    public Medico atualizar(@RequestBody Medico medico) {
        return this.medicoService.atualizar(medico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        this.medicoService.deletar(id);
    }

//    @GetMapping("/{id}/horarios/detalhes")
//    public List<Scheduling.HorarioAtendimentoResponse> listarDetalhesHorarios(@PathVariable Long id) {
//        return medicoService.listarDetalhesHorarios(id);
//    }

//    @PostMapping("/{id}/horarios")
//    public ResponseEntity<String> adicionarHorarios(@PathVariable Long id, @RequestBody List<HorarioAtendimento> horarios) {
//        Medico medico = medicoService.buscarPorId(id);
//        if (medico == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado.");
//        }
//
//        for (HorarioAtendimento horario : horarios) {
//            horario.setMedico(medico);
//            horarioAtendimentoRepository.save(horario);
//        }
//
//        return ResponseEntity.ok("Horários adicionados com sucesso!");
//    }

    // @GetMapping("/{id}/horarios")
    // public List<Long> listarHorarios(@PathVariable Long id) {
    //     return medicoService.listarHorariosPorMedico(id);
    // }

//    @PutMapping("/{id}/horarios/vincular/{horarioId}")
//    public boolean vincularHorario(@PathVariable Long id, @PathVariable Long horarioId) {
//        return medicoService.vincularHorario(id, horarioId);
//    }

    // @PutMapping("/{id}/horarios/desvincular/{horarioId}")
    // public boolean desvincularHorario(@PathVariable Long id, @PathVariable Long horarioId) {
    //     return medicoService.desvincularHorario(id, horarioId);
    // }

}
package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Medico;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.service.MedicoService;
import clinix.com.clinix_sistema_usuarios.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {

        this.medicoService = medicoService;
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
        System.out.println("Recebendo paciente: " + medico);
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
}
package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Gerente;
import clinix.com.clinix_sistema_usuarios.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    private GerenteService gerenteService;

    @Autowired
    public GerenteController(GerenteService gerenteService) {

        this.gerenteService = gerenteService;
    }

    @GetMapping("/list")
    public List<Gerente> listar() {
        return this.gerenteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Gerente buscar(@PathVariable Long id) {
        return this.gerenteService.buscarPorId(id);
    }

    @PostMapping("/save")
    public Gerente criar(@RequestBody Gerente gerente) {
        System.out.println("Recebendo gerente: " + gerente);
        return this.gerenteService.salvar(gerente);
    }

    @PutMapping("/atualizar/{id}")
    public Gerente atualizar(@RequestBody Gerente gerente) {
        return this.gerenteService.atualizar(gerente);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        this.gerenteService.deletar(id);
    }

    /*
    @GetMapping("/{id}/clinicas")  // 🔹 Novo endpoint
    public List<Clinica> listarClinicas(@PathVariable Long id) {
        return gerenteService.listarClinicasPorGerente(id);
    }

     */
}
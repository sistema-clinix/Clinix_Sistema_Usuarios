package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.dto.ClinicaDTO;
import clinix.com.clinix_sistema_usuarios.model.Gerente;
import clinix.com.clinix_sistema_usuarios.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


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


    @PutMapping("/{id}")
    public Gerente atualizar(@RequestBody Gerente gerente) {
        return this.gerenteService.atualizar(gerente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        this.gerenteService.deletar(id);
    }

//    @GetMapping("/{id}/clinicas")  // listar clinicas
//    public List<Long> listarClinicas(@PathVariable Long id) {
//        return gerenteService.listarClinicas(id);
//    }

    @PutMapping("/{id}/clinica/registrar")  // 🔹 atualiza o banco de dados cadastrando um novo registro de clínica e atualizando o gerente do id informado
    public boolean cadastrarClinica(@PathVariable("id") Long g_id, @RequestBody ClinicaDTO c){
        return gerenteService.cadastrarClinica(g_id, c);
    }
    @PutMapping("/{id}/clinica/remover")  // 
    public boolean removerClinica(@PathVariable("id") Long g_id, @RequestBody ClinicaDTO c){
        return gerenteService.removerClinica(g_id, c);
    }
    
}
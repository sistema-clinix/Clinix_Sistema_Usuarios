

package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Usuario;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/list")
    public List<Usuario> listar() {
        return this.usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return this.usuarioService.buscarPorId(id);
    }

    @PostMapping("/save")
    public Usuario criar(@RequestBody Paciente usuario) {
        System.out.println("Recebendo usuário: " + usuario);
        return this.usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return this.usuarioService.atualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        this.usuarioService.deletar(id);
    }
}

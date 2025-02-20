

package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Usuario;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    public UsuarioController(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    @GetMapping("/list")
    public List<Usuario> listar() {
        return this.usuarioServiceImpl.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return this.usuarioServiceImpl.buscarPorId(id);
    }

    @PostMapping("/save")
    public Usuario criar(@RequestBody Paciente usuario) {
        System.out.println("Recebendo usuário: " + usuario);
        return this.usuarioServiceImpl.salvar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return this.usuarioServiceImpl.atualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        this.usuarioServiceImpl.deletar(id);
    }
}

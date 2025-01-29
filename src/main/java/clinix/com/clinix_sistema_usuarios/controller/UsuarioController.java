

package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Usuario;
import clinix.com.clinix_sistema_usuarios.model.UsuarioComum;
import clinix.com.clinix_sistema_usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public Usuario criar(@RequestBody UsuarioComum usuario) {
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



package clinix.com.clinix_sistema_usuarios.controller;

import clinix.com.clinix_sistema_usuarios.model.Usuario;
import clinix.com.clinix_sistema_usuarios.service.UsuarioService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.buscarPorId(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public Usuario criar(@Valid @RequestBody Usuario usuario) {
        System.out.println("Recebendo usuário: " + usuario);
        return this.usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuarioAtualizado) {
        try {
            usuarioAtualizado.setId(id);
            Usuario usuarioAtualizadoResult = usuarioService.atualizar(usuarioAtualizado);
            return new ResponseEntity<>(usuarioAtualizadoResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            usuarioService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @GetMapping("/buscarPorNome")
    // public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam String nome) {
    //     List<Usuario> usuarios = usuarioService.buscarPorNome(nome);
    //     return new ResponseEntity<>(usuarios, HttpStatus.OK);
    // }

    // @GetMapping("/buscarPorEmail")
    // public ResponseEntity<Usuario> buscarPorEmail(@RequestParam String email) {
    //     return usuarioService.buscarPorEmail(email)
    //             .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
    //             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    // @GetMapping("/buscarPorNomeUsuario")
    // public ResponseEntity<Usuario> buscarPorNomeUsuario(@RequestParam String nomeUsuario) {
    //     return usuarioService.buscarPorNomeUsuario(nomeUsuario)
    //             .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
    //             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }
}

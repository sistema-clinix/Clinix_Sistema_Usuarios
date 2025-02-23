// package clinix.com.clinix_sistema_usuarios.controller;

// import clinix.com.clinix_sistema_usuarios.model.Usuario;
// import clinix.com.clinix_sistema_usuarios.service.UsuarioServiceImpl;
// import jakarta.validation.Valid;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/usuario")
// public class UsuarioController {

//     @Autowired
//     private UsuarioServiceImpl usuarioServiceImpl;

//     // public UsuarioController(UsuarioServiceImpl usuarioServiceImpl) {
//     //     this.usuarioServiceImpl = usuarioServiceImpl;
//     // }

//     @GetMapping("/list")
//     public List<Usuario> listar() {
//         return this.usuarioServiceImpl.listarTodos();
//     }

//     @GetMapping("/{id}")
//     public Usuario buscar(@PathVariable Long id) {
//         return this.usuarioServiceImpl.buscarPorId(id);
//     }

//     @PostMapping("/save")
//     public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario) {
//         System.out.println("Recebendo usuário: " + usuario);
//         Usuario usuarioSalvo = this.usuarioServiceImpl.salvar(usuario);
//         return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
//     }

//     @PutMapping("/{id}")
//     public Usuario atualizar(@RequestBody Usuario usuario) {
//         return this.usuarioServiceImpl.atualizar(usuario);
//     }

//     @DeleteMapping("/{id}")
//     public void deletar(@PathVariable Long id) {
//         this.usuarioServiceImpl.deletar(id);
//     }
// }

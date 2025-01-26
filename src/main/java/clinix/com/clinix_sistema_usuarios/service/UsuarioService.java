package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.model.Usuario;
import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizar(Integer id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);
        usuario.atualizar(usuarioAtualizado);
        return usuarioRepository.save(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(Long.valueOf(id));
    }


}

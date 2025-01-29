package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.model.Usuario;
import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuarioAtualizado) {
        //Usuario usuario = buscarPorId(id);
        //usuario.atualizar(usuarioAtualizado);
        //return usuarioRepository.save(usuario);
        return this.usuarioRepository.save(usuarioAtualizado);
    }

    public void deletar(Long id) {
        this.usuarioRepository.deleteById(id);
    }

}

package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import clinix.com.clinix_sistema_usuarios.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario salvar(Usuario usuario) {
        // Aqui você pode adicionar regras de negócio antes de salvar o usuário, como validar os dados, criptografar a senha, etc.
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        Usuario usuarioExistente = buscarPorId(usuario.getId()); // Garante que o usuário existe
        //TODO: Implemente a atualização dos atributos do usuárioExistente com os valores do usuário
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        Usuario usuario = buscarPorId(id); // Garante que o usuário existe
        usuarioRepository.delete(usuario);
    }
}


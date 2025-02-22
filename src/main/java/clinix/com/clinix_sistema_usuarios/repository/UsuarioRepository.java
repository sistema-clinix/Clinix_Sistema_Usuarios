package clinix.com.clinix_sistema_usuarios.repository;

import clinix.com.clinix_sistema_usuarios.model.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}

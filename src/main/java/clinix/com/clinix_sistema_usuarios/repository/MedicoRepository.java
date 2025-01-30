package clinix.com.clinix_sistema_usuarios.repository;
import clinix.com.clinix_sistema_usuarios.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
}



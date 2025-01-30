package clinix.com.clinix_sistema_usuarios.repository;

import clinix.com.clinix_sistema_usuarios.model.Gerente;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}





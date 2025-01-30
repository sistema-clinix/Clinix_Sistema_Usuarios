package clinix.com.clinix_sistema_usuarios.repository;

import clinix.com.clinix_sistema_usuarios.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}




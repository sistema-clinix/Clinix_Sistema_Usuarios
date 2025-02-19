package clinix.com.clinix_sistema_usuarios.repository;

import clinix.com.clinix_sistema_usuarios.dto.PacienteRmiDTO;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    @Query("SELECT new clinix.com.clinix_sistema_usuarios.dto.PacienteRmiDTO(p.id, p.nome) FROM Paciente p WHERE p.id = :id")
    PacienteRmiDTO findPacienteRmiDTOById(@Param("id") Long id);
}




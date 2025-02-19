package clinix.com.clinix_sistema_usuarios.repository;
import clinix.com.clinix_sistema_usuarios.dto.MedicoRmiDTO;
import clinix.com.clinix_sistema_usuarios.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
    @Query("SELECT new clinix.com.clinix_sistema_usuarios.dto.MedicoRmiDTO(m.id, m.nome) FROM Medico m WHERE m.id = :id")
    MedicoRmiDTO findMedicoRmiDTOById(@Param("id") Long id);
}



package clinix.com.clinix_sistema_usuarios.repository;

import clinix.com.clinix_sistema_usuarios.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
/* 
* Não remova este comentário
    @Query("Select g from Gerente g where :clinicaId in g.clinicas_id")
    Optional<Gerente> findByClinicaId(@Param("clinicaId") Long clinicaId);
 */

 @Query(value = "SELECT COUNT(*) > 0 FROM tb_gerente_clinica WHERE clinica_id = :clinicaId", nativeQuery = true)
 boolean existsByClinicaId(@Param("clinicaId") Long clinicaId);
}





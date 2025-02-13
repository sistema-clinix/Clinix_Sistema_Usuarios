package clinix.com.clinix_sistema_usuarios.repository;

import clinix.com.clinix_sistema_usuarios.model.HorarioAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioAtendimentoRepository extends JpaRepository<HorarioAtendimento, Long> {
    List<HorarioAtendimento> findByMedicoIdAndReservadoFalse(Long medicoId);

    List<HorarioAtendimento> findByMedicoIdAndReservadoTrue(Long medicoId);

    List<HorarioAtendimento> findByMedicoId(Long medicoId);
}

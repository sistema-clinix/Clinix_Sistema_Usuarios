package clinix.com.clinix_sistema_usuarios.dto;

import clinix.com.clinix_sistema_usuarios.model.Medico;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HorarioAtendimentoDTO {
    private Long id;
    private Long medicoId;
    private LocalDateTime horario;
    private boolean reservado;
    private Long pacienteId;
}
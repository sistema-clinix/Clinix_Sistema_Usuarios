package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.dto.MedicoRmiDTO;
import clinix.com.clinix_sistema_usuarios.model.Medico;
import clinix.com.clinix_sistema_usuarios.model.NullMedico;
import clinix.com.clinix_sistema_usuarios.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final GerenteService gerenteService;

    @Autowired
    public MedicoService(GerenteService gerenteService, MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
        this.gerenteService = gerenteService;
    }

    public List<Medico> listarTodos() {
        return this.medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return this.medicoRepository.findById(id).orElse(new NullMedico());
    }

    public MedicoRmiDTO buscarPorIdRmiDto(Long id) {
        return this.medicoRepository.findMedicoRmiDTOById(id);
    }

    public Medico salvar(Medico medico) {
        return this.medicoRepository.save(medico);
    }

    public Medico atualizar(Medico medicoAtualizado) {
        // Usuario usuario = buscarPorId(id);
        // usuario.atualizar(usuarioAtualizado);
        // return usuarioRepository.save(usuario);
        return this.medicoRepository.save(medicoAtualizado);
    }

    public void deletar(Long id) {
        this.medicoRepository.deleteById(id);
    }

    // public List<Long> listarHorariosPorMedico(Long medicoId) {
    //     Medico medico = buscarPorId(medicoId);
    //     return medico != null ? medico.getHorariosAtendimento() : null;
    // }

    // public boolean desvincularHorario(Long medicoId, Long horarioId) {
    //     Medico medico = buscarPorId(medicoId);
    //     if (medico != null && medico.getHorariosAtendimento().contains(horarioId)) {
    //         medico.getHorariosAtendimento().remove(horarioId);
    //         medicoRepository.save(medico);
    //         return true;
    //     }
    //     return false;
    // }

}

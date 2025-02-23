package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.dto.MedicoRmiDTO;
import clinix.com.clinix_sistema_usuarios.dto.PacienteRmiDTO;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return this.pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return this.pacienteRepository.findById(id).orElse(null);
    }

    public PacienteRmiDTO buscarPorIdRmiDto(Long id) {
        return this.pacienteRepository.findPacienteRmiDTOById(id);
    }

    public Paciente salvar(Paciente paciente) {
        return this.pacienteRepository.save(paciente);
    }

    public Paciente atualizar(Paciente pacienteAtualizado) {
        //Usuario usuario = buscarPorId(id);
        //usuario.atualizar(usuarioAtualizado);
        //return usuarioRepository.save(usuario);
        return this.pacienteRepository.save(pacienteAtualizado);
    }

    public void deletar(Long id) {
        this.pacienteRepository.deleteById(id);
    }
}

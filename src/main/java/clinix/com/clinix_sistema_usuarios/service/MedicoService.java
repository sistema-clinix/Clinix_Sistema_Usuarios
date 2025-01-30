package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.model.Medico;
import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> listarTodos() {
        return this.medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return this.medicoRepository.findById(id).orElse(null);
    }

    public Medico salvar(Medico medico) {
        return this.medicoRepository.save(medico);
    }

    public Medico atualizar(Medico medicoAtualizado) {
        //Usuario usuario = buscarPorId(id);
        //usuario.atualizar(usuarioAtualizado);
        //return usuarioRepository.save(usuario);
        return this.medicoRepository.save(medicoAtualizado);
    }

    public void deletar(Long id) {
        this.medicoRepository.deleteById(id);
    }
}

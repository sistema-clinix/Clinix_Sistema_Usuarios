package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.model.Medico;
import clinix.com.clinix_sistema_usuarios.model.NullMedico;
import clinix.com.clinix_sistema_usuarios.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Long> listarClinicas(Long m_id) {
        Medico m = this.medicoRepository.findById(m_id).orElse(new NullMedico());
        return m.listarClinicas();
    }

//    public boolean vincular(Long m_id, Long c_id) {
//        Medico m = this.medicoRepository.findById(m_id).orElse(new NullMedico());
//        if (!m.isNull() && this.gerenteService.checkClinicaExiste(c_id)) {
//            if (!m.getClinicas_id().contains(c_id)){
//                m.vincular(c_id);
//                this.salvar(m);
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean desvincular(Long m_id, Long c_id) {
//        Medico m = this.medicoRepository.findById(m_id).orElse(new NullMedico());
//        if (!m.isNull() && m.getClinicas_id().contains(c_id)) {
//                m.desvincular(c_id);
//                this.salvar(m);
//                return true;
//            }
//        return false;
//    }

}

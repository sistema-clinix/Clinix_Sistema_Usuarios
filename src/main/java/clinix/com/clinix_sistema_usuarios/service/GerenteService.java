package clinix.com.clinix_sistema_usuarios.service;

import clinix.com.clinix_sistema_usuarios.model.Gerente;
import clinix.com.clinix_sistema_usuarios.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    private final GerenteRepository gerenteRepository;

    @Autowired
    public GerenteService(GerenteRepository gerenteRepository){
        this.gerenteRepository = gerenteRepository;
    }

    public List<Gerente> listarTodos() {
        return this.gerenteRepository.findAll();
    }

    public Gerente buscarPorId(Long id) {
        return this.gerenteRepository.findById(id).orElse(null);
    }

    public Gerente salvar(Gerente gerente) {
        return this.gerenteRepository.save(gerente);
    }

    public Gerente atualizar(Gerente gerenteAtualizado) {
        return this.gerenteRepository.save(gerenteAtualizado);
    }

    public void deletar(Long id) {
        this.gerenteRepository.deleteById(id);
    }

<<<<<<< Updated upstream
=======
    public List<Long> listarClinicas(Long g_id) {
        Gerente g = this.gerenteRepository.findById(g_id).orElse(new NullGerente());
        return g.getClinicas_id();
    }
    
/*     public Gerente findGerenteByClinic(ClinicaDTO c){
        return this.gerenteRepository.findByClinicaId(c.id()).orElse( new NullGerente());
    } */
    
    /**
     * Armazena a referência do id de uma clínica a um determinado gerente
     * @param g_id id do gerente
     * @param c objeto DTO da Clinica
     * @return
     */
    public Boolean cadastrarClinica(Long g_id, ClinicaDTO c) {
        Gerente g = this.gerenteRepository.findById(g_id).orElse(new NullGerente());
        if(g.isNull() || this.checkClinicaExiste(c.id())){
            return false;
        }
        g.cadastrarClinica(c.id());
        salvar(g);
        return true;
    }

    /**
     * Remove a referência do id de uma clínica a um determinado gerente
     * @param g_id
     * @param c
     * @return
     */
    public Boolean removerClinica(Long g_id, ClinicaDTO c) {
        Gerente g = this.gerenteRepository.findById(g_id).orElse(new NullGerente());
        
        /******* TO DO **********/
        /******* Regras negociais **********/
        if(g.isNull() || !this.checkClinicaExiste(c.id())) {
            return false;
        }
        g.removerClinica(c.id());
        salvar(g);
        return true;
    }
>>>>>>> Stashed changes

    public boolean checkClinicaExiste(Long c_id){
        return this.gerenteRepository.existsByClinicaId(c_id);
    }

}

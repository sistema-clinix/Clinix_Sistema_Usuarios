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


}

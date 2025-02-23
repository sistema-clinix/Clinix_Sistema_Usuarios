// package clinix.com.clinix_sistema_usuarios.service;

// import clinix.com.clinix_sistema_usuarios.dto.MedicoRmiDTO;
// import clinix.com.clinix_sistema_usuarios.dto.PacienteRmiDTO;
// import clinix.com.clinix_sistema_usuarios.model.Paciente;
// import clinix.com.clinix_sistema_usuarios.model.Usuario;
// import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.rmi.RemoteException;
// import java.rmi.server.UnicastRemoteObject;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class UsuarioServiceImpl extends UnicastRemoteObject implements UsuarioService {
//     private final UsuarioRepository usuarioRepository;
//     private final MedicoService medicoService;
//     private final PacienteService pacienteService;

//     @Autowired
//     public UsuarioServiceImpl(UsuarioRepository usuarioRepository, MedicoService medicoService, PacienteService pacienteService) throws RemoteException {
//         super();
//         this.usuarioRepository = usuarioRepository;
//         this.medicoService = medicoService;
//         this.pacienteService = pacienteService;
//     }

//     public List<Usuario> listarTodos() {
//         return this.usuarioRepository.findAll();
//     }

//     public Usuario buscarPorId(Long id) {
//         return this.usuarioRepository.findById(id).orElse(null);
//     }

//     public Usuario salvar(Usuario usuario) {
//         return this.usuarioRepository.save(usuario);
//     }

//     public Usuario atualizar(Usuario usuarioAtualizado) {
//         //Usuario usuario = buscarPorId(id);
//         //usuario.atualizar(usuarioAtualizado);
//         //return usuarioRepository.save(usuario);
//         return this.usuarioRepository.save(usuarioAtualizado);
//     }

//     public void deletar(Long id) {
//         this.usuarioRepository.deleteById(id);
//     }

//     @Override
//     public MedicoRmiDTO getMedicoPorId(Long id) throws RemoteException {
//         System.out.println(id);
//         return medicoService.buscarPorIdRmiDto(id);
//     }

//     @Override
//     public PacienteRmiDTO getPacientePorId(Long id) throws RemoteException {
//         System.out.println(id);
//         return pacienteService.buscarPorIdRmiDto(id);
//     }

// }

// package clinix.com.clinix_sistema_usuarios.rmi;

// import clinix.com.clinix_sistema_usuarios.service.UsuarioService;
// import clinix.com.clinix_sistema_usuarios.service.UsuarioServiceImpl;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import java.rmi.Naming;
// import java.rmi.registry.LocateRegistry;

// @Component
// public class UsuarioServer implements CommandLineRunner {

//     private final UsuarioService usuarioService;

//     @Autowired
//     public UsuarioServer(UsuarioService usuarioService) {
//         this.usuarioService = usuarioService;
//     }

//     @Override
//     public void run(String... args) throws Exception {
//         try {
//             LocateRegistry.createRegistry(1099);
//             Naming.rebind("rmi://localhost:1099/UsuarioService", usuarioService);

//             System.out.println("Servidor RMI de Usuarios iniciado...");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

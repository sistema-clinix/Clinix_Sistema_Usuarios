//package clinix.com.clinix_sistema_usuarios.grpc;
//
//import clinix.com.clinix_sistema_usuarios.service.UserServiceGrpcImpl;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class GRpcServerConfig {
//
//    @Bean
//    public Server grpcServer(UserServiceGrpcImpl userServiceGrpcImpl) throws IOException {
//        Server server = ServerBuilder.forPort(9090)
//                .addService(userServiceGrpcImpl)
//                .build();
//        server.start();
//        return server;
//    }
//}

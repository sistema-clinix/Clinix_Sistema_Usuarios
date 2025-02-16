//package clinix.com.clinix_sistema_usuarios.grpc;
//
//import clinix.com.clinix_sistema_usuarios.service.UserServiceGrpcImpl;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserClient {
//
//    public void getUserById(Long id) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
//                .usePlaintext()
//                .build();
//
//        UserServiceGrpcImpl.UserServiceBlockingStub stub =
//                UserServiceGrpcImpl.newBlockingStub(channel);
//
//        UserProto.UsuarioResponse response = stub.getUserById(
//                UserProto.UsuarioRequest.newBuilder().setId(id).build()
//        );
//
//        System.out.println("Usuário Recebido: " + response.getNome());
//
//        channel.shutdown();
//    }
//}
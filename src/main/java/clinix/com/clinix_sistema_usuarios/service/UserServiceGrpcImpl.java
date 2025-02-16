//package clinix.com.clinix_sistema_usuarios.service;
//
//import clinix.com.clinix_sistema_usuarios.grpc.UserServiceGrpc;
//import io.grpc.stub.StreamObserver;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceGrpcImpl extends UserServiceGrpcImpl.UserServiceImplBase {
//
//    @Override
//    public void getUserById(UserProto.UsuarioRequest request,
//                               StreamObserver<UserProto.UsuarioResponse> responseObserver) {
//        UserProto.UsuarioResponse usuarioResponse = UserProto.UsuarioResponse.newBuilder()
//                .setId(request.getId())
//                .setNome("Teste gRPC")
//                .setEmail("teste@grpc.com")
//                .build();
//
//        responseObserver.onNext(usuarioResponse);
//        responseObserver.onCompleted();
//    }
//}
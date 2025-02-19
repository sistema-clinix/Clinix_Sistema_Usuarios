package clinix.com.clinix_sistema_usuarios.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import scheduling.SchedulingServiceGrpc;

@Configuration
public class GrpcConfig {

    @Bean
    public ManagedChannel schedulingServiceChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
    }

    @Bean
    public SchedulingServiceGrpc.SchedulingServiceBlockingStub petServiceStub(ManagedChannel channel) {
        return SchedulingServiceGrpc.newBlockingStub(channel);
    }
}

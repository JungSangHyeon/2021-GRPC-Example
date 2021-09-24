import com.demo.grpc.HelloRequest;
import com.demo.grpc.HelloResponse;
import com.demo.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setFirstName("Jung")
                .setLastName("SangHyeon")
                .build();
        HelloResponse helloResponse = stub.hello(helloRequest);
        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}

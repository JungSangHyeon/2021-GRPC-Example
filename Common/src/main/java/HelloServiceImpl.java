import com.demo.grpc.HelloRequest;
import com.demo.grpc.HelloResponse;
import com.demo.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello " + request.getFirstName()+" "+request.getLastName();
        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}

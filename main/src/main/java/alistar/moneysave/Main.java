package alistar.moneysave;

import alista.moneysave.helloworld.GreeterGrpc;
import alista.moneysave.helloworld.HelloReply;
import alista.moneysave.helloworld.HelloRequest;
import alistar.moneysave.bank.*;
import alistar.moneysave.data.Repository;
import domain.entity.Bank;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static Repository repository;

    private static String getJwt() {
        return Jwts.builder()
                .setSubject("GreetingClient") // client's identifier
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
                .compact();
    }

    public static void main(String[] args) {
        repository = new Repository();

        System.out.println(getJwt());

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(ProtoReflectionService.newInstance())
                .addService(new GreeterImpl())
                .addService(new BankImpl(repository))
                .build();

        try {
            server.start();
            logger.info("Server started, listening on " + port);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.err.println("*** shutting down gRPC server since JVM is shutting down");
                    try {
                        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                    System.err.println("*** server shut down");
                }
            });
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName() + " Your age is " + req.getAge()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

    }

    public static class BankImpl extends BankServiceGrpc.BankServiceImplBase {

        private final Repository repository;

        public BankImpl(Repository repository) {
            this.repository = repository;
        }

        @Override
        public void createBank(CreateBankRequest request, StreamObserver<CreateBankReply> responseObserver) {
            Bank bank = new Bank();
            bank.setName(request.getName());
            bank.setPersianName(request.getPersianName());
            bank.setSmsRegex(request.getSmsRegex());

            String bankId = repository.saveBank(bank);

            CreateBankReply reply = CreateBankReply.newBuilder()
                    .setBank(alistar.moneysave.bank.Bank.newBuilder()
                            .setId(bankId)
                            .setName(bank.getName())
                            .setPersianName(bank.getPersianName())
                            .build())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void removeBank(RemoveBankRequest request, StreamObserver<RemoveBankReplay> responseObserver) {
            boolean removeBankOk = repository.removeBank(request.getId());
            String message;
            if (removeBankOk) {
                message = "bank removed, bankId: " + request.getId();
            } else {
                message = "an error occurred while removing bank";
            }
            RemoveBankReplay replay = RemoveBankReplay.newBuilder()
                    .setMessage(message)
                    .build();
            responseObserver.onNext(replay);
            responseObserver.onCompleted();
        }

        @Override
        public void getBanks(GetBanksRequest request, StreamObserver<GetBanksReplay> responseObserver) {
            GetBanksReplay.Builder getBanksReplay = GetBanksReplay.newBuilder();

            for (Bank bank : repository.getBanks(request.getLimit(), request.getOffset())) {
                getBanksReplay.addBanks(alistar.moneysave.bank.Bank.newBuilder()
                        .setId(bank.getId().toString())
                        .setName(bank.getName())
                        .setPersianName(bank.getPersianName())
                        .build());
            }

            responseObserver.onNext(getBanksReplay.build());
            responseObserver.onCompleted();
        }
    }

}

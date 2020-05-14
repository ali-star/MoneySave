package alistar.moneysave;

import alista.moneysave.helloworld.GreeterGrpc;
import alista.moneysave.helloworld.HelloReply;
import alista.moneysave.helloworld.HelloRequest;
import alistar.moneysave.bank.BankServiceGrpc;
import alistar.moneysave.bank.CreateBankReply;
import alistar.moneysave.bank.CreateBankRequest;
import alistar.moneysave.bank.GetBanksReplay;
import alistar.moneysave.data.DataSource;
import alistar.moneysave.data.Repository;
import alistar.moneysave.entity.Bank;
import alistar.moneysave.entity.Card;
import com.google.gson.Gson;
import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.stub.StreamObserver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static DataSource dataSource;
    private static Scanner scanner = new Scanner(System.in);
    private static Gson gson = new Gson();
    private static SessionFactory sessionFactory;
    private static Repository repository;

    public static void main(String[] args) {
        repository = new Repository();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(ProtoReflectionService.newInstance())
                .addService(new GreeterImpl())
                .addService(new BankImpl())
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

    private static boolean nextCommand (Command command) {
        switch (command) {
            case INIT:
                initData(true);
                return true;

            case GET:
                getData();
                return true;

            case LEFT:
                dataSource.setLeftMoney(scanner.nextDouble());
                dataSource.saveData();
                System.out.println("Saved");
                getData();
                return true;

            case NEW_BANK:
                System.out.println();
                System.out.print("bank name: ");
                Bank bank = new Bank();
                bank.setName(scanner.next());
                newBank(bank);
                return true;

            case NEW_CARD:
                System.out.println();
                Card card = new Card();

                System.out.println("card name: ");
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Query getBanksQuery = session.createQuery("from Bank");

                for (int i = 0 ; i < getBanksQuery.list().size(); i++) {
                    Bank qBank = (Bank) getBanksQuery.list().get(i);
                    System.out.println(i + " " + qBank.getName());
                }

                Bank selectedBank = (Bank) getBanksQuery.list().get(scanner.nextInt());
                System.out.println(gson.toJson(selectedBank));
                card.setBank(selectedBank);

                session.getTransaction().commit();
                session.close();

                System.out.print("card name: ");
                card.setName(scanner.next());
                System.out.println();

                System.out.print("card number: ");
                card.setNumber(scanner.next());
                System.out.println();

                System.out.print("account number: ");
                card.setAccountNumber(scanner.next());
                System.out.println();

                System.out.print("cvv2: ");
                card.setCvv2(scanner.next());
                System.out.println();

                System.out.print("expire year: ");
                card.setExpireYear(scanner.next());
                System.out.println();

                System.out.print("expire month: ");
                card.setExpireMonth(scanner.next());
                System.out.println();

                newCard(card);
                break;

            case EXIT:
                return false;
        }
        return false;
    }

    private static void newBank(Bank bank) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bank);
        session.getTransaction().commit();
        session.close();
        System.out.println("bank created");
    }

    private static void newCard (Card card) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
        session.close();
        System.out.println("card created");
    }

    private static void getData() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String s =
                "Total: " + decimalFormat.format(dataSource.getTotalMoney()) + "T" + "\n" +
                        "Reduced: " + decimalFormat.format(dataSource.getReducedMoney()) + "T" + "\n" +
                        "Spent: " + decimalFormat.format(dataSource.getMoneySpent()) + "T" + "\n" +
                        "Left: " + decimalFormat.format(dataSource.getLeftMoney()) + "T" + "\n" +
                        "Saved: " + decimalFormat.format(dataSource.getSavedMoney()) + "T";
        System.out.println(s);
    }

    private enum Command {
        INIT("init"), EXIT("exit"), GET("get"), LEFT("left"), NEW_BANK("new-bank"),
        NEW_CARD("new-card");

        private final String value;

        Command (String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Command get (String value) {
            for (Command command : values())
                if (command.getValue().equals(value))
                    return command;
            return null;
        }
    }

    private static void initData(boolean overwrite) {
        if (overwrite || !dataSource.isDataExists()) {
            System.out.print("Enter total money: ");
            dataSource.setTotalMoney(scanner.nextDouble());
            System.out.println();

            System.out.print("Enter reduced money: ");
            dataSource.setReducedMoney(scanner.nextDouble());
            System.out.println();

            System.out.print("Enter left money: ");
            dataSource.setLeftMoney(scanner.nextDouble());
            System.out.println();
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

    static class BankImpl extends BankServiceGrpc.BankServiceImplBase {

        @Override
        public void createBank(CreateBankRequest request, StreamObserver<CreateBankReply> responseObserver) {
            CreateBankReply reply = CreateBankReply.newBuilder().setMessage("Bank created: id = " + request.getName() + "").build();

            Bank bank = new Bank();
            bank.setName(request.getName());
            bank.setPersianName(request.getPersianName());
            repository.saveBank(bank);

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void getBanks(Empty request, StreamObserver<GetBanksReplay> responseObserver) {
            GetBanksReplay.Builder getBanksReplay = GetBanksReplay.newBuilder();
            getBanksReplay.addBanks(alistar.moneysave.bank.Bank.newBuilder().setName("test").build());

            responseObserver.onNext(getBanksReplay.build());
            responseObserver.onCompleted();
        }
    }

}

package alistar.moneysave;

import alistar.moneysave.bank.*;
import alistar.moneysave.data.Repository;
import domain.entity.Bank;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BankGrpcSave {

    @Rule
    public final GrpcCleanupRule grpcCleanupRule = new GrpcCleanupRule();

    private final Repository repository = new Repository();

    private BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;

    private Bank getBankById(String bankId) {
        Bank testBank = null;
        List<Bank> banks = repository.getBanks(100, 0);
        for (Bank bank : banks) {
            if (bank.getId().toString().equals(bankId)) {
                testBank = bank;
                break;
            }
        }
        return testBank;
    }

    private Bank getBankByName(String bankName) {
        Bank testBank = null;
        List<Bank> banks = repository.getBanks(100, 0);
        for (Bank bank : banks) {
            if (bank.getName().equals(bankName)) {
                testBank = bank;
                break;
            }
        }
        return testBank;
    }

    @BeforeEach
    void initGrpc() throws Exception {
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanupRule.register(InProcessServerBuilder.forName(serverName)
                .directExecutor()
                .addService(new Main.BankImpl(repository))
                .build()
                .start());

        bankServiceBlockingStub = BankServiceGrpc
                .newBlockingStub(grpcCleanupRule.register(InProcessChannelBuilder.forName(serverName)
                        .directExecutor()
                        .build()));
    }

    @Test
    public void createBankTest() {
        CreateBankRequest request = CreateBankRequest.newBuilder()
                .setName("Test Bank")
                .setPersianName("بانک تست")
                .setSmsRegex("\\*\\W+\\*\\n\\W+\\n\\W+(?<AccountNumber>\\d.+)\\n\\W+(?<Amount>\\d.+)\\s+\\W+\\n((?<Year>\\d{2})\\/(?<Month>\\d{2})\\/(?<Day>\\d{2}))\\w((?<Hour>\\d{2})\\W(?<Minute>\\d{2}))\\n\\W+(?<Inventory>\\d.+) \\W+")
                .build();
        CreateBankReply reply = bankServiceBlockingStub.createBank(request);

        Bank testBank = getBankById(reply.getBank().getId());
        assertNotNull(testBank);
    }

    @Test
    public void removeBankTest() {
        Bank bank = getBankByName("Test Bank");

        assertNotNull(bank);

        RemoveBankRequest request = RemoveBankRequest
                .newBuilder()
                .setId(bank.getId().toString())
                .build();

        RemoveBankReplay replay = bankServiceBlockingStub.removeBank(request);

        assertEquals("bank removed, bankId: " + bank.getId(), replay.getMessage());
    }

}

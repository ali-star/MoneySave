package domain.entity;

import com.google.gson.annotations.SerializedName;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "transactionId")
    @SerializedName("transactionId")
    private UUID id;

    @SerializedName("date")
    private Data data;

    @SerializedName("type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @SerializedName("bankAccountNumber")
    private String bankAccountNumber;

    @SerializedName("amount")
    private double amount;

    @SerializedName("balance")
    private double balance;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public enum Type {
        UNKNOWN("UNKNOWN"), WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public static Type getByValue(String value) {
            Type[] values = values();
            for (int i =0; i < value.length(); i++) {
                if (values[i].value.equals(value))
                    return values[i];
            }
            return UNKNOWN;
        }

        @Override
        public String toString() {
            return value;
        }

    }

}

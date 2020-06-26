package domain.entity;

import com.google.gson.annotations.SerializedName;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "BankAccount")
public class BankAccount {

    @Id
    @Column(name = "bankAccountId")
    @GeneratedValue
    @SerializedName("bankAccountId")
    private UUID id;

    @SerializedName("createDate")
    private Data createDate;

    @SerializedName("updateDate")
    private Data updateDate;

    @SerializedName("bankId")
    private UUID bankId;

    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private String number;

    @SerializedName("balance")
    private double balance;

    @SerializedName("currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Data getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Data createDate) {
        this.createDate = createDate;
    }

    public Data getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Data updateDate) {
        this.updateDate = updateDate;
    }

    public UUID getBankId() {
        return bankId;
    }

    public void setBankId(UUID bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}

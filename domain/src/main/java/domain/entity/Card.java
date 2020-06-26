package domain.entity;

import com.google.gson.annotations.SerializedName;
import javax.persistence.*;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @Column(name = "cardId")
    @GeneratedValue
    @SerializedName("cardId")
    private long id;

    @SerializedName("bankId")
    private String bankId;

    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private String number;

    @SerializedName("expireYear")
    private String expireYear;

    @SerializedName("expireMonth")
    private String expireMonth;

    @SerializedName("cvv2")
    private String cvv2;

    @SerializedName("accountNumber")
    private String accountNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
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

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

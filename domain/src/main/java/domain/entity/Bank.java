package domain.entity;

import com.google.gson.annotations.SerializedName;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @Column(name = "bankId")
    @GeneratedValue
    @SerializedName("bankId")
    private UUID id;

    @SerializedName("name")
    private String name;

    @SerializedName("persianName")
    private String persianName;

    @SerializedName("smsRegex")
    private String smsRegex;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public String getSmsRegex() {
        return smsRegex;
    }

    public void setSmsRegex(String smsRegex) {
        this.smsRegex = smsRegex;
    }

}

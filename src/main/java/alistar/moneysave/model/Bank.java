package alistar.moneysave.model;

import com.google.gson.annotations.SerializedName;
import javax.persistence.*;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @Column(name = "bankId")
    @GeneratedValue
    @SerializedName("bankId")
    private long id;

    @SerializedName("name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

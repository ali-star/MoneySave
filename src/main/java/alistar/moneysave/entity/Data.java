package alistar.moneysave.entity;

import com.google.gson.annotations.SerializedName;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Data")
public class Data {

    @Id
    private int id = 1;

    @SerializedName("TotalMoney")
    private double totalMoney;

    @SerializedName("LeftMoney")
    private double leftMoney;

    @SerializedName("ReducedMoney")
    private double reducedMoney;

    @SerializedName("SavedMoney")
    private double savedMoney;

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public double getReducedMoney() {
        return reducedMoney;
    }

    public void setReducedMoney(double reducedMoney) {
        this.reducedMoney = reducedMoney;
    }

    public void setSavedMoney(double savedMoney) {
        this.savedMoney = savedMoney;
    }

    public double getSavedMoney() {
        return savedMoney;
    }
}

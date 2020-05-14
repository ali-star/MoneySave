package alistar.moneysave.data;

import alistar.moneysave.entity.Data;

public interface DataSource {

    boolean isDataExists();
    void readData();
    Data getData();
    void saveData();
    void setTotalMoney(double totalMoney);
    void setLeftMoney(double leftMoney);
    void setReducedMoney(double reducedMoney);
    void setSavedMoney(double savedMoney);
    double getMoneySpent();
    double getTotalMoney();
    double getLeftMoney();
    double getReducedMoney();
    double getSavedMoney();

}

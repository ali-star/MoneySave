package alistar.moneysave.data;

import alistar.moneysave.date.CivilDate;
import alistar.moneysave.date.PersianDate;
import alistar.moneysave.model.Data;
import alistar.moneysave.date.utils.CalendarType;
import alistar.moneysave.date.utils.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.*;
import java.util.Calendar;

public class Repository implements DataSource {

    private Data data;
    private SessionFactory sessionFactory;

    public Repository () {
        sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
    }

    public boolean isDataExists() {
        if (data == null)
            readData();
        return data != null;
    }

    public void readData() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Data");
        if (query.list().size() > 0)
            data = (Data) query.list().get(0);
        else
            data = new Data();
        session.getTransaction().commit();
        session.close();
    }

    public Data getData() {
        if (data == null)
            readData();
        return data;
    }

    public void saveData() {
        calculateSavedMoney();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(data);
        session.getTransaction().commit();
        session.close();
    }

    public void setTotalMoney(double totalMoney) {
        data.setTotalMoney(totalMoney);
    }

    public void setLeftMoney(double leftMoney) {
        data.setLeftMoney(leftMoney);
    }

    public void setReducedMoney(double reducedMoney) {
        data.setReducedMoney(reducedMoney);
    }

    public void setSavedMoney(double savedMoney) {
        data.setSavedMoney(savedMoney);
    }

    public double getMoneySpent() {
        return (data.getTotalMoney() - data.getReducedMoney()) - data.getLeftMoney();
    }

    public double getTotalMoney() {
        return data.getTotalMoney();
    }

    public double getLeftMoney() {
        return data.getLeftMoney();
    }

    public double getReducedMoney() {
        return data.getReducedMoney();
    }

    public double getSavedMoney() {
        return data.getSavedMoney();
    }

    private void calculateSavedMoney () {
        PersianDate persianDate = new PersianDate(new CivilDate(Calendar.getInstance()));
        int daysInMonth = DateUtils.getMonthLength(CalendarType.SHAMSI, persianDate.getYear(), persianDate.getMonth());
        int today = persianDate.getDayOfMonth() - 1;
        double averageSpendPerDay = (data.getTotalMoney() - data.getReducedMoney()) / daysInMonth;
        double moneySpent = (data.getTotalMoney() - data.getReducedMoney()) - data.getLeftMoney();
        data.setSavedMoney((averageSpendPerDay * today) - moneySpent);
    }
}

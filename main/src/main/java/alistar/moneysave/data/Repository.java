package alistar.moneysave.data;

import domain.entity.Bank;
import domain.entity.Card;
import domain.entity.Data;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.util.List;

public class Repository implements DataSource {

    private Data data;
    private SessionFactory sessionFactory;

    public Repository () {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Card.class)
                .addAnnotatedClass(Bank.class)
                .configure();
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        configuration.setSessionFactoryObserver(new SessionFactoryObserver() {
            @Override
            public void sessionFactoryCreated(SessionFactory factory) {
                System.out.println("sessionFactoryCreated");
            }

            @Override
            public void sessionFactoryClosed(SessionFactory factory) {
                System.out.println("sessionFactoryClosed");
            }

            @Override
            public void sessionFactoryClosing(SessionFactory factory) {
                System.out.println("sessionFactoryClosing");
            }
        });

        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            e.printStackTrace();
            System.out.println("cannot create sessionFactory: " + e.getMessage());
            System.exit(1);
        }
    }

    public String saveBank(Bank bank) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable generatedIdentifier = session.save(bank);
        session.getTransaction().commit();
        session.close();
        return generatedIdentifier.toString();
    }

    public boolean removeBank(String bankId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        boolean isSuccessful;
        try {
            session.createQuery("delete from Bank where bankId = '" + bankId + "'");
            isSuccessful = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            isSuccessful = false;
        }
        session.close();
        return isSuccessful;
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
        /*PersianDate persianDate = new PersianDate(new CivilDate(Calendar.getInstance()));
        int daysInMonth = DateUtils.getMonthLength(CalendarType.SHAMSI, persianDate.getYear(), persianDate.getMonth());
        int today = persianDate.getDayOfMonth() - 1;
        double averageSpendPerDay = (data.getTotalMoney() - data.getReducedMoney()) / daysInMonth;
        double moneySpent = (data.getTotalMoney() - data.getReducedMoney()) - data.getLeftMoney();
        data.setSavedMoney((averageSpendPerDay * today) - moneySpent);*/
    }

    public List<Bank> getBanks(int limit, int offset) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Bank");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }
}

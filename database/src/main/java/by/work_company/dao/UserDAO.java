package by.work_company.dao;

import by.work_company.entity.User;
import com.sun.xml.txw2.output.DumpSerializer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    private static UserDAO INSTANCE = null;

    private UserDAO(){}

    public static UserDAO getInstance(){
        if(INSTANCE==null){
            synchronized (UserDAO.class){
                if(INSTANCE==null){
                    INSTANCE = new UserDAO();
                }
            }
        }
        return INSTANCE;
    }

    public User find(int id) {

        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        return user;
    }
}

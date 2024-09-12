package org.bazaarBackend.User.Repository;

import jakarta.persistence.Query;
import org.bazaarBackend.User.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public User createUser(User user) {
        User U = new User();
        U.setAge(user.getAge());
        U.setEmailId(user.getEmailId());
        U.setPassword(user.getPassword());
        U.setName(user.getName());
        System.out.println("---- age --- " + U.getAge());
        Configuration config = new Configuration().addAnnotatedClass(User.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(U);

        tx.commit();
        return U;
    }

    public User getUser(User userDetails) {
        Transaction tx = null;
        Configuration config = new Configuration().addAnnotatedClass(User.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        User result = null;
        try {
            Session session = sf.openSession();
             tx = session.beginTransaction();

            String hql = "from User where emailId = :emailId and password = :password";
            Query query = session.createQuery(hql, User.class);

            query.setParameter("emailId", userDetails.getEmailId());
            query.setParameter("password", userDetails.getPassword());
            result = (User)query.getSingleResult();

            // commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
//        finally {
//            session.close();
//        }

        return result;


    }
}

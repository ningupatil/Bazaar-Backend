package org.bazaarBackend.User.Repository;

import jakarta.persistence.Query;
import org.bazaarBackend.Response.Response;
import org.bazaarBackend.User.Dtos.UserDto;
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

    public UserDto createUser(UserDto user) {
        User U = new User();
        U.setAge(user.getAge());
        U.setEmailId(user.getEmail());
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

        UserDto userDto = new UserDto(U);
        return userDto;
    }

    public UserDto getUser(UserDto userDetails) {
        Transaction tx = null;
        Configuration config = new Configuration().addAnnotatedClass(User.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        User result = null;
        UserDto userDto = null;
        try {
            Session session = sf.openSession();
             tx = session.beginTransaction();

            String hql = "from User where id = :userId and emailId = :emailId " ;
//                    " and password = :password";
            Query query = session.createQuery(hql, User.class);

            query.setParameter("emailId", userDetails.getEmail());
//            query.setParameter("password", userDetails.getPassword());
            query.setParameter("userId", userDetails.getId());
            result = (User) query.getSingleResult();

            // commit transaction
            tx.commit();
            userDto = new UserDto(result);

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
//        finally {
//            session.close();
//        }
//        Response response = new Response(userDto);
        return userDto;


    }
}

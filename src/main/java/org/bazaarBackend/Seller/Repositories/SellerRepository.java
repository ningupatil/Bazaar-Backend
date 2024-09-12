package org.bazaarBackend.Seller.Repositories;

import org.bazaarBackend.Seller.Models.Seller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRepository {

    public Seller createSeller(Seller seller) {
        Seller s = new Seller();
        s.setName(seller.getName());
        s.setAge(seller.getAge());
        s.setMobileNo(seller.getMobileNo());
        s.setEmail(seller.getEmail());
        s.setPassword(seller.getPassword());
        s.setShopName(seller.getShopName());
        s.setShopGstNo(seller.getShopGstNo());

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();

        // Create session factory instance
        SessionFactory factory = configuration.addAnnotatedClass(Seller.class).buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.persist(s);

        tx.commit();
        return s;
    }
}

package org.bazaarBackend.Cart.Repository;

import org.bazaarBackend.Cart.Model.Cart;
import org.bazaarBackend.User.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    public Cart createCart(Cart cart) {
        Cart c = new Cart();
        c.setUserId(cart.getUserId());

        Configuration config = new Configuration().addAnnotatedClass(Cart.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);

        tx.commit();
        return c;
    }

}

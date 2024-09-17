package org.bazaarBackend.Product.Repositories;
import org.bazaarBackend.Models.Brand;
import org.bazaarBackend.Models.Category;
import org.bazaarBackend.Models.ProductImages;
import org.bazaarBackend.Product.Models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public Product createProduct(Product product) {
        System.out.println("---- inserting prod 1 ---");
        Product P = new Product();
        P.setTitle(product.getTitle());
        P.setPrice(product.getPrice());
        P.setDescription(product.getDescription());

        Brand b = new Brand();
        b.setId(product.getBrandId());
        P.setBrand(b);

        Category c = new Category();
        c.setId(product.getCategoryId());
        P.setCategory(c);
        System.out.println("---- inserting prod ---");

        Configuration config = new Configuration().addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(ProductImages.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(P);

        tx.commit();
        return P;
    }

    public ProductImages createProductImage(ProductImages productImage) {
        System.out.println("---- inserting prod image --- " + productImage.getImagePath());
        Configuration config = new Configuration().addAnnotatedClass(ProductImages.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Brand.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(productImage);

        tx.commit();
        return productImage;
    }

    public List<Product> getAllProducts() {
        Configuration config = new Configuration().addAnnotatedClass(ProductImages.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Brand.class)
                .configure("Hibernate.cfg.xml");
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Transaction tx = null;
        List<Product> productList = null;
        ArrayList<Product> list = new ArrayList<>();
        try {
            Session session = sf.openSession();


            //HQL example - Get All Products
            tx = session.beginTransaction();
            Query query = session.createQuery("from Product");
            productList = query.getResultList();

            for (Product product : productList) {
                Product p = new Product();
                p.setTitle(product.getTitle());
                p.setId(product.getId());
                p.setProductImages(product.getProductImages());

                for (ProductImages pi : p.getProductImages()) {
                    System.out.println("image " + pi.getImagePath() + " id " + pi.getId());
                }
                list.add(p);
//               System.out.println("List of Products::"+product.getId()+","+product.getTitle()+
//                       ","+product.getImages()+","+product.getPrice()+","+product.getProductImages()+
//                       ","+product.getDescription()+","+product.getBrand().getId()+","+product.getCategory().getId());
            }


            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }


   public List<Product> getCategoryProducts(String category) {
       Configuration config = new Configuration().addAnnotatedClass(ProductImages.class)
               .addAnnotatedClass(Product.class)
               .addAnnotatedClass(Category.class)
               .addAnnotatedClass(Brand.class)
               .configure("Hibernate.cfg.xml");
       ServiceRegistry reg = new StandardServiceRegistryBuilder()
               .applySettings(config.getProperties())
               .build();
       SessionFactory sf = config.buildSessionFactory(reg);
       Transaction tx = null;
       List<Product> productList = null;
       ArrayList<Product> list = new ArrayList<>();
        try {
            Session session = sf.openSession();
            tx = session.beginTransaction();

            String hql = "from Product p inner join p.category c inner join p.brand b where c.name = :categoryName";
//            String hql = "from Product inner join category where category_id = category.id";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("categoryName", category);
            productList = query.getResultList();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return productList;
   }
}

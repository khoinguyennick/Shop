package com.Desert.Repository;

import com.Desert.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoBean implements ProductRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProductsOfCategory(long categoryID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query =
                session.createQuery("FROM Product WHERE categoryID = :categoryID", Product.class);
        query.setParameter("categoryID", categoryID);
        return query.getResultList();
    }

    @Override
    public Product getProduct(long productID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, productID);
    }

    @Override
    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query =
                session.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void insertProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(long productID) {
        Product product = this.getProduct(productID);

        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }
}

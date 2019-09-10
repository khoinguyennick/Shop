package com.Desert.Repository;

import com.Desert.Entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepoBean implements CategoryRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getCategoryList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query =
                session.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

    @Override
    public Category getCategory(long categoryID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, categoryID);
    }
}

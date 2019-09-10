package com.Desert.Repository;

import com.Desert.Entity.ReceiptDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailRepoBean implements DetailRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertDetails(List<ReceiptDetail> detailList) {
        Session session = sessionFactory.getCurrentSession();
        detailList.forEach(session::saveOrUpdate);
    }
}

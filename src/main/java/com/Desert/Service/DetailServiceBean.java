package com.Desert.Service;

import com.Desert.Entity.ReceiptDetail;
import com.Desert.Repository.DetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DetailServiceBean implements DetailService {

    @Autowired
    private DetailRepo detailRepo;

    @Override
    public void insertDetails(List<ReceiptDetail> detailList) {
        detailRepo.insertDetails(detailList);
    }
}

package com.Desert.Service;

import com.Desert.Entity.Receipt;
import com.Desert.Repository.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReceiptServiceBean implements ReceiptService {

    @Autowired
    private ReceiptRepo receiptRepo;

    @Override
    public long insertReceipt(Receipt receipt) {
        return receiptRepo.insertReceipt(receipt);
    }
}

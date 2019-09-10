package com.Desert.Repository;

import com.Desert.Entity.ReceiptDetail;

import java.util.List;

public interface DetailRepo {

    void insertDetails(List<ReceiptDetail> detailList);
}

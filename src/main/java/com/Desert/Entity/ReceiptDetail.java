package com.Desert.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ReceiptDetail")
@Getter
@Setter
public class ReceiptDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ReceiptDetailID receiptDetailID;
    @Column(name = "price")
    private double price;

}

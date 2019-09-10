package com.Desert.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthday")
    private java.sql.Date birthday;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Receipt> receiptSet;

}

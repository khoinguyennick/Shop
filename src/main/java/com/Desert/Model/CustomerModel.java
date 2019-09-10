package com.Desert.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerModel {

    @NotNull
    private String name;
    private String phone;
    private java.sql.Date birthday;
    private String email;
}

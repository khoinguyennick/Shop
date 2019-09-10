package com.Desert.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductModel {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private long categoryID;
    private String description;
    @NotNull
    private double price;
}

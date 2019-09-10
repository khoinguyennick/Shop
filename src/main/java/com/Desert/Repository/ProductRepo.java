package com.Desert.Repository;

import com.Desert.Entity.Product;

import java.util.List;

public interface ProductRepo {

    List<Product> getProductsOfCategory(long categoryID);

    Product getProduct(long productID);

    List<Product> getProductList();

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(long productID);
}

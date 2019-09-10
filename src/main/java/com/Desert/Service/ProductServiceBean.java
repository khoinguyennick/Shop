package com.Desert.Service;

import com.Desert.Entity.Product;
import com.Desert.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceBean implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProductsOfCategory(long categoryID) {
        return productRepo.getProductsOfCategory(categoryID);
    }

    @Override
    public Product getProduct(long productID) {
        return productRepo.getProduct(productID);
    }

    @Override
    public List<Product> getProductList() {
        return productRepo.getProductList();
    }

    @Override
    public void insertProduct(Product product) {
        productRepo.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    @Override
    public void deleteProduct(long productID) {
        productRepo.deleteProduct(productID);
    }
}

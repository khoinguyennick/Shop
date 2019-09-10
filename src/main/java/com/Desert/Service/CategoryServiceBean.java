package com.Desert.Service;

import com.Desert.Entity.Category;
import com.Desert.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceBean implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getCategoryList() {
        return categoryRepo.getCategoryList();
    }

    @Override
    public Category getCategory(long categoryID) {
        return categoryRepo.getCategory(categoryID);
    }
}

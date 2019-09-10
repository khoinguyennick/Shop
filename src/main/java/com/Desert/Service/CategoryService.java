package com.Desert.Service;

import com.Desert.Entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoryList();

    Category getCategory(long categoryID);
}

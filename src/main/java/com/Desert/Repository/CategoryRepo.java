package com.Desert.Repository;

import com.Desert.Entity.Category;

import java.util.List;

public interface CategoryRepo {

    List<Category> getCategoryList();

    Category getCategory(long categoryID);
}

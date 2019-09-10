package com.Desert.Controller;

import com.Desert.Service.CategoryService;
import com.Desert.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{categoryID}/products")
    public ModelAndView getProductsOfCategory(@PathVariable long categoryID) {
        return new ModelAndView("products")
                .addObject("category", categoryService.getCategory(categoryID))
                .addObject("productList", productService.getProductsOfCategory(categoryID));
    }
}

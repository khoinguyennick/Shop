package com.Desert.Controller;

import com.Desert.Entity.Product;
import com.Desert.Model.ProductModel;
import com.Desert.Service.CategoryService;
import com.Desert.Service.CustomerService;
import com.Desert.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ModelAndView admin() {
        return new ModelAndView("admin-home");
    }

    @GetMapping("/product")
    public ModelAndView getProducts() {
        return new ModelAndView("admin-product")
                .addObject("productList", productService.getProductList());
    }

    @GetMapping("/new-product")
    public ModelAndView gotoProductForm() {
        ProductModel productModel = new ProductModel();
        return new ModelAndView("product-form")
                .addObject("action", "/admin/add-product")
                .addObject("buttonText", "Add Product")
                .addObject("categoryList", categoryService.getCategoryList())
                .addObject("productModel", productModel);
    }

    @PostMapping("/add-product")
    public String addProduct(@Valid @ModelAttribute ProductModel productModel, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("categoryList", categoryService.getCategoryList());
            return "product-form";
        }

//        TODO: Save uploaded File

        Product product = new Product();
        product.setName(productModel.getName());
        product.setCategory(categoryService.getCategory(productModel.getCategoryID()));
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        productService.insertProduct(product);

        return "redirect:/admin/product";
    }

    @GetMapping("/edit-product/{productID}")
    public ModelAndView editProduct(@PathVariable long productID) {
        Product product = productService.getProduct(productID);

        ProductModel productModel = new ProductModel();
        productModel.setId(productID);
        productModel.setName(product.getName());
        productModel.setCategoryID(product.getCategory().getId());
        productModel.setDescription(product.getDescription());
        productModel.setPrice(product.getPrice());

        return new ModelAndView("product-form")
                .addObject("action", "/admin/update-product")
                .addObject("buttonText", "Update Product")
                .addObject("categoryList", categoryService.getCategoryList())
                .addObject("productModel", productModel);
    }

    @PostMapping("/update-product")
    public String updateProduct(@Valid @ModelAttribute ProductModel productModel, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("productModel", productModel);
            modelMap.addAttribute("categoryList", categoryService.getCategoryList());
            return "product-form";
        }

//        TODO: Save uploaded File

        Product product = productService.getProduct(productModel.getId());
        product.setName(productModel.getName());
        product.setCategory(categoryService.getCategory(productModel.getCategoryID()));
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());

        productService.updateProduct(product);

        return "redirect:/admin/product";
    }

    @GetMapping("/delete-product/{productID}")
    public String deleteProduct(@PathVariable long productID) {
        productService.deleteProduct(productID);
        return "redirect:/admin/product";
    }

    @GetMapping("/customer")
    public ModelAndView getCustomers() {
        return new ModelAndView("admin-customer")
                .addObject("customerList", customerService.getCustomerList());
    }
}

package com.Desert.Controller;

import com.Desert.Entity.Customer;
import com.Desert.Entity.Product;
import com.Desert.Service.CategoryService;
import com.Desert.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ModelAndView home(HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        session.setAttribute("cart", cart);

        return new ModelAndView("home")
                .addObject("categoryList", categoryService.getCategoryList());
    }

    @GetMapping("/receipts")
    public ModelAndView receipts(HttpSession session) {
        Customer customer = null;
        try {
            long customerID = (long) session.getAttribute("customerID");
            customer = customerService.getCustomer(customerID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("receipts")
                .addObject("customer", customer);
    }


}

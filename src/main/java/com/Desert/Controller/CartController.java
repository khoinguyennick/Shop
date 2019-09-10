package com.Desert.Controller;

import com.Desert.Entity.*;
import com.Desert.Model.CustomerModel;
import com.Desert.Service.CustomerService;
import com.Desert.Service.DetailService;
import com.Desert.Service.ProductService;
import com.Desert.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private DetailService detailService;

    @GetMapping("/add-to-cart/{productID}")
    public String addProductToCart(@PathVariable long productID, HttpSession session) {
        Product product = productService.getProduct(productID);
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        cart.add(product);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public ModelAndView cart() {
        return new ModelAndView("cart")
                .addObject("customerModel", new CustomerModel());
    }

    @PostMapping("/checkout")
    public String checkout(@Valid @ModelAttribute CustomerModel customerModel, BindingResult bindingResult, HttpSession session, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "redirect:/cart";
        }

        Customer customer = new Customer();
        customer.setName(customerModel.getName());
        customer.setPhone(customerModel.getPhone());
        customer.setBirthday(customerModel.getBirthday());
        customer.setEmail(customerModel.getEmail());

        long customerID = customerService.insertCustomer(customer);
        customer.setId(customerID);

        Receipt receipt = new Receipt();
        receipt.setCustomer(customer);
        long receiptID = receiptService.insertReceipt(receipt);
        receipt.setId(receiptID);


        List<Product> cart = (List<Product>) session.getAttribute("cart");
        List<ReceiptDetail> detailList = new ArrayList<>();
        cart.forEach(product -> {
            ReceiptDetail detail = new ReceiptDetail();
            detail.setReceiptDetailID(new ReceiptDetailID(receipt, product));
            detail.setPrice(product.getPrice());
            detailList.add(detail);
        });

        detailService.insertDetails(detailList);
        cart = new ArrayList<>();
        session.setAttribute("cart", cart);
        session.setAttribute("customerID", customerID);

        modelMap.addAttribute("notification", "Checkout successfully!");
        return "checkout";
    }
}
